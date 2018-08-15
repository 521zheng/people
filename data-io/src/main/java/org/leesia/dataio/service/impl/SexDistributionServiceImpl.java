package org.leesia.dataio.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.dao.SexDistributionMapper;
import org.leesia.dataio.service.SexDistributionService;
import org.leesia.entity.SexDistribution;
import org.leesia.entity.SexDistributionCriteria;
import org.leesia.enums.Sex;
import org.leesia.util.UUIDTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 12:53
 * @Description:
 */
@Service("sexDistributionService")
public class SexDistributionServiceImpl implements SexDistributionService {

    private static final Logger logger = LoggerFactory.getLogger(SexDistributionServiceImpl.class);

    @Autowired
    private SexDistributionMapper mapper;

    @Override
    public int insert(SexDistribution distribution) {
        logger.info("增加性别分布：{}", distribution.getSex());
        if (StringUtils.isBlank(distribution.getId())) {
            distribution.setId(UUIDTool.uuid());
        }
        return mapper.insertSelective(distribution);
    }

    @Override
    public List<SexDistribution> get(Map<String, Object> params) {
        logger.info("查询性别分布：{}", params);
        SexDistributionCriteria criteria = createCriteria(params);
        return mapper.selectByExample(criteria);
    }

    @Override
    public SexDistribution getBySex(Sex sex) {
        logger.info("查询性别分布：{}", sex.getDesc());
        Map<String, Object> params = new HashMap<>();
        params.put("sex", sex.getSex());
        SexDistributionCriteria criteria = createCriteria(params);
        List<SexDistribution> provinces = mapper.selectByExample(criteria);

        if (provinces != null && !provinces.isEmpty()) {
            return provinces.get(0);
        }
        return null;
    }

    @Override
    public int delete(SexDistribution distribution) {
        logger.info("删除性别分布：{}", distribution.getId());
        if (StringUtils.isBlank(distribution.getId())) {
            logger.error("删除性别分布失败，主键为空");
            return 0;
        }
        return mapper.deleteByPrimaryKey(distribution.getId());
    }

    @Override
    public int update(SexDistribution distribution) {
        logger.info("更新性别分布：{}", distribution.getId());
        if (StringUtils.isBlank(distribution.getId())) {
            logger.error("更新性别分布失败，主键为空");
            return 0;
        }
        return mapper.updateByPrimaryKeySelective(distribution);
    }

    private SexDistributionCriteria createCriteria(Map<String, Object> params) {
        SexDistributionCriteria criteria = new SexDistributionCriteria();
        SexDistributionCriteria.Criteria c = criteria.createCriteria();

        String id = (String) params.get("id");
        if (StringUtils.isNotBlank(id)) {
            c.andIdEqualTo(id);
        }

        Integer sex = (Integer) params.get("sex");
        if (sex != null) {
            c.andSexEqualTo(sex);
        }

        return criteria;
    }
}
