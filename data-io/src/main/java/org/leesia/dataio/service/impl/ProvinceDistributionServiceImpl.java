package org.leesia.dataio.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.dao.ProvinceDistributionMapper;
import org.leesia.dataio.dao.ext.ExtProvinceDistributionMapper;
import org.leesia.dataio.service.ProvinceDistributionService;
import org.leesia.entity.ProvinceDistribution;
import org.leesia.entity.ProvinceDistributionCriteria;
import org.leesia.util.UUIDTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 16:42
 * @Description:
 */
@Service("provinceDistributionService")
public class ProvinceDistributionServiceImpl implements ProvinceDistributionService {

    private static final Logger logger = LoggerFactory.getLogger(ProvinceDistributionServiceImpl.class);

    @Autowired
    private ProvinceDistributionMapper mapper;

    @Autowired
    private ExtProvinceDistributionMapper extMapper;

    @Override
    public int insert(ProvinceDistribution distribution) {
        logger.info("增加省份人口分布：{}", distribution.getProvinceName());
        if (StringUtils.isBlank(distribution.getId())) {
            distribution.setId(UUIDTool.uuid());
        }
        return mapper.insertSelective(distribution);
    }

    @Override
    public int batchInsert(List<ProvinceDistribution> distributions) {
        logger.info("批量增加省份人口分布：{}", distributions.size());
        if (distributions.isEmpty()) {
            logger.error("批量增加省份人口分布失败，没有要添加的省份人口分布");
            return 0;
        }
        for (ProvinceDistribution distribution : distributions) {
            if (StringUtils.isBlank(distribution.getId())) {
                distribution.setId(UUIDTool.uuid());
            }
            if (distribution.getCreateDatetime() == null) {
                distribution.setCreateDatetime(new Date());
            }
            if (distribution.getUpdateDatetime() == null) {
                distribution.setUpdateDatetime(new Date());
            }
        }
        return extMapper.bacthInsert(distributions);
    }

    @Override
    public List<ProvinceDistribution> get(Map<String, Object> params) {
        logger.info("查询省份人口分布：{}", params);
        ProvinceDistributionCriteria criteria = createCriteria(params);
        return mapper.selectByExample(criteria);
    }

    @Override
    public ProvinceDistribution getByProvince(String provinceName) {
        logger.info("查询省份人口分布：{}", provinceName);
        Map<String, Object> params = new HashMap<>();
        params.put("provinceName", provinceName);
        ProvinceDistributionCriteria criteria = createCriteria(params);
        List<ProvinceDistribution> distributions = mapper.selectByExample(criteria);

        if (distributions != null && !distributions.isEmpty()) {
            return distributions.get(0);
        }
        return null;
    }

    @Override
    public int delete(ProvinceDistribution distribution) {
        logger.info("删除省份人口分布：{}", distribution.getId());
        if (StringUtils.isBlank(distribution.getId())) {
            logger.error("删除省份人口分布失败，主键为空");
            return 0;
        }
        return mapper.deleteByPrimaryKey(distribution.getId());
    }

    @Override
    public int update(ProvinceDistribution distribution) {
        logger.info("更新省份人口分布：{}", distribution.getId());
        if (StringUtils.isBlank(distribution.getId())) {
            logger.error("更新省份人口分布失败，主键为空");
            return 0;
        }
        return mapper.updateByPrimaryKeySelective(distribution);
    }

    private ProvinceDistributionCriteria createCriteria(Map<String, Object> params) {
        ProvinceDistributionCriteria criteria = new ProvinceDistributionCriteria();
        ProvinceDistributionCriteria.Criteria c = criteria.createCriteria();

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
