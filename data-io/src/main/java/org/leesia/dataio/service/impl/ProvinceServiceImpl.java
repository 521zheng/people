package org.leesia.dataio.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.dao.ext.ExtProvinceMapper;
import org.leesia.dataio.dao.ProvinceMapper;
import org.leesia.dataio.redis.RedisKeyPrefix;
import org.leesia.dataio.redis.RedisService;
import org.leesia.dataio.service.ProvinceService;
import org.leesia.entity.Province;
import org.leesia.entity.ProvinceCriteria;
import org.leesia.util.UUIDTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 09:02
 * @Description:
 */
@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {

    private static final Logger logger = LoggerFactory.getLogger(ProvinceServiceImpl.class);

    @Autowired
    private ProvinceMapper mapper;

    @Autowired
    private ExtProvinceMapper extMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public int insert(Province province) {
        logger.info("增加省份：{}", province.getProvinceName());
        if (StringUtils.isBlank(province.getId())) {
            province.setId(UUIDTools.uuid());
        }
        int insert = mapper.insertSelective(province);
        redisService.setObject(RedisKeyPrefix.ProvincePrefix.getPrefix() + province.getProvinceName(), province, 60, TimeUnit.SECONDS);

        return insert;
    }

    @Override
    public int batchInsert(List<Province> provinces) {
        logger.info("批量增加省份：{}", provinces.size());
        if (provinces.isEmpty()) {
            logger.error("批量增加省份失败，没有要添加的省份");
            return 0;
        }
        for (Province province : provinces) {
            if (StringUtils.isBlank(province.getId())) {
                province.setId(UUIDTools.uuid());
            }
            if (province.getCreateDatetime() == null) {
                province.setCreateDatetime(new Date());
            }
            if (province.getUpdateDatetime() == null) {
                province.setUpdateDatetime(new Date());
            }
        }
        return extMapper.bacthInsert(provinces);
    }

    @Override
    public List<Province> get(Map<String, Object> params) {
        logger.info("查询省份：{}", params);
        ProvinceCriteria criteria = createCriteria(params);
        return mapper.selectByExample(criteria);
    }

    @Override
    public Province getByName(String provinceName) {
        logger.info("查询省份：{}", provinceName);
        Province province = (Province) redisService.getObject(RedisKeyPrefix.ProvincePrefix.getPrefix() + provinceName);
        if (province == null) {
            Map<String, Object> params = new HashMap<>();
            params.put("provinceName", provinceName);
            ProvinceCriteria criteria = createCriteria(params);
            List<Province> provinces = mapper.selectByExample(criteria);

            if (provinces != null && !provinces.isEmpty()) {
                province = provinces.get(0);
                redisService.setObject(RedisKeyPrefix.ProvincePrefix.getPrefix() + provinceName, province, 60, TimeUnit.SECONDS);
            }
        }

        return province;
    }

    @Override
    public int delete(Province province) {
        logger.info("删除省份：{}", province.getId());
        if (StringUtils.isBlank(province.getId())) {
            logger.error("删除省份失败，主键为空");
            return 0;
        }
        int delete = mapper.deleteByPrimaryKey(province.getId());
        redisService.deleteObject(RedisKeyPrefix.ProvincePrefix.getPrefix() + province.getProvinceName());

        return delete;
    }

    @Override
    public int update(Province province) {
        logger.info("更新省份：{}", province.getId());
        if (StringUtils.isBlank(province.getId())) {
            logger.error("更新省份失败，主键为空");
            return 0;
        }
        int update = mapper.updateByPrimaryKeySelective(province);
        redisService.setObject(RedisKeyPrefix.ProvincePrefix.getPrefix() + province.getProvinceName(), province, 60, TimeUnit.SECONDS);

        return update;
    }

    private ProvinceCriteria createCriteria(Map<String, Object> params) {
        ProvinceCriteria criteria = new ProvinceCriteria();
        ProvinceCriteria.Criteria c = criteria.createCriteria();

        String id = (String) params.get("id");
        if (StringUtils.isNotBlank(id)) {
            c.andIdEqualTo(id);
        }

        String provinceName = (String) params.get("provinceName");
        if (StringUtils.isNotBlank(provinceName)) {
            c.andProvinceNameLike("%" + provinceName + "%");
        }

        return criteria;
    }
}
