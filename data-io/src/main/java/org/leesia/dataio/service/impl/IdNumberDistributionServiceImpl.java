package org.leesia.dataio.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.dao.IdNumberDistributionMapper;
import org.leesia.dataio.dao.ext.ExtIdNumberDistributionMapper;
import org.leesia.dataio.service.IdNumberDistributionService;
import org.leesia.entity.IdNumberDistribution;
import org.leesia.entity.IdNumberDistributionCriteria;
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
 * @Date: 2018/8/11 13:19
 * @Description:
 */
@Service("idNumberDistributionService")
public class IdNumberDistributionServiceImpl implements IdNumberDistributionService {

    private static final Logger logger = LoggerFactory.getLogger(IdNumberDistributionServiceImpl.class);

    @Autowired
    private IdNumberDistributionMapper mapper;

    @Autowired
    private ExtIdNumberDistributionMapper extMapper;

    @Override
    public int insert(IdNumberDistribution distribution) {
        logger.info("增加身份证号码分布：{}", distribution.getProvinceName());
        if (StringUtils.isBlank(distribution.getId())) {
            distribution.setId(UUIDTool.uuid());
        }
        return mapper.insertSelective(distribution);
    }

    @Override
    public int batchInsert(List<IdNumberDistribution> distributions) {
        logger.info("批量增加身份证号码分布：{}", distributions.size());
        if (distributions.isEmpty()) {
            logger.error("批量增加身份证号码分布失败，没有要添加的身份证号码分布");
            return 0;
        }
        for (IdNumberDistribution distribution : distributions) {
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
    public List<IdNumberDistribution> get(Map<String, Object> params) {
        logger.info("查询身份证号码分布：{}", params);
        IdNumberDistributionCriteria criteria = createCriteria(params);
        return mapper.selectByExample(criteria);
    }

    @Override
    public IdNumberDistribution getByProvince(String provinceName) {
        logger.info("查询身份证号码分布：{}", provinceName);
        Map<String, Object> params = new HashMap<>();
        params.put("provinceName", provinceName);
        IdNumberDistributionCriteria criteria = createCriteria(params);
        List<IdNumberDistribution> distributions = mapper.selectByExample(criteria);

        if (distributions != null && !distributions.isEmpty()) {
            return distributions.get(0);
        }
        return null;
    }

    @Override
    public int delete(IdNumberDistribution distribution) {
        logger.info("删除身份证号码分布：{}", distribution.getId());
        if (StringUtils.isBlank(distribution.getId())) {
            logger.error("删除身份证号码分布失败，主键为空");
            return 0;
        }
        return mapper.deleteByPrimaryKey(distribution.getId());
    }

    @Override
    public int update(IdNumberDistribution distribution) {
        logger.info("更新身份证号码分布：{}", distribution.getId());
        if (StringUtils.isBlank(distribution.getId())) {
            logger.error("更新身份证号码分布失败，主键为空");
            return 0;
        }
        return mapper.updateByPrimaryKeySelective(distribution);
    }

    private IdNumberDistributionCriteria createCriteria(Map<String, Object> params) {
        IdNumberDistributionCriteria criteria = new IdNumberDistributionCriteria();
        IdNumberDistributionCriteria.Criteria c = criteria.createCriteria();

        String id = (String) params.get("id");
        if (StringUtils.isNotBlank(id)) {
            c.andIdEqualTo(id);
        }

        String province = (String) params.get("province");
        if (StringUtils.isNotBlank(province)) {
            c.andProvinceEqualTo(province);
        }

        String provinceName = (String) params.get("provinceName");
        if (StringUtils.isNotBlank(provinceName)) {
            c.andProvinceNameLike("%" + province + "%");
        }

        return criteria;
    }
}
