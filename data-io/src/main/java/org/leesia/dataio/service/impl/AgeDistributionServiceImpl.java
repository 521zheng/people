package org.leesia.dataio.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.dao.AgeDistributionMapper;
import org.leesia.dataio.service.AgeDistributionService;
import org.leesia.entity.AgeDistribution;
import org.leesia.entity.AgeDistributionCriteria;
import org.leesia.util.UUIDTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 13:23
 * @Description:
 */
@Service("ageDistributionService")
public class AgeDistributionServiceImpl implements AgeDistributionService {

    private static final Logger logger = LoggerFactory.getLogger(AgeDistributionServiceImpl.class);

    @Autowired
    private AgeDistributionMapper mapper;

    @Override
    public int insert(AgeDistribution distribution) {
        logger.info("增加年龄分布：{}-{}", distribution.getMinAge(), distribution.getMaxAge());
        if (StringUtils.isBlank(distribution.getId())) {
            distribution.setId(UUIDTool.uuid());
        }
        return mapper.insertSelective(distribution);
    }

    @Override
    public List<AgeDistribution> get(Map<String, Object> params) {
        logger.info("查询年龄分布：{}", params);
        AgeDistributionCriteria criteria = createCriteria(params);
        return mapper.selectByExample(criteria);
    }

    @Override
    public AgeDistribution getByAge(int age) {
        logger.info("查询年龄分布：{}", age);
        AgeDistributionCriteria criteria = new AgeDistributionCriteria();
        AgeDistributionCriteria.Criteria c = criteria.createCriteria();
        c.andMinAgeLessThanOrEqualTo(age);
        c.andMaxAgeGreaterThan(age);

        List<AgeDistribution> provinces = mapper.selectByExample(criteria);

        if (provinces != null && !provinces.isEmpty()) {
            return provinces.get(0);
        }
        return null;
    }

    @Override
    public int delete(AgeDistribution distribution) {
        logger.info("删除年龄分布：{}", distribution.getId());
        if (StringUtils.isBlank(distribution.getId())) {
            logger.error("删除年龄分布失败，主键为空");
            return 0;
        }
        return mapper.deleteByPrimaryKey(distribution.getId());
    }

    @Override
    public int update(AgeDistribution distribution) {
        logger.info("更新年龄分布：{}", distribution.getId());
        if (StringUtils.isBlank(distribution.getId())) {
            logger.error("更新年龄分布失败，主键为空");
            return 0;
        }
        return mapper.updateByPrimaryKeySelective(distribution);
    }

    private AgeDistributionCriteria createCriteria(Map<String, Object> params) {
        AgeDistributionCriteria criteria = new AgeDistributionCriteria();
        AgeDistributionCriteria.Criteria c = criteria.createCriteria();

        String id = (String) params.get("id");
        if (StringUtils.isNotBlank(id)) {
            c.andIdEqualTo(id);
        }

        Integer minAge = (Integer) params.get("minAge");
        if (minAge != null) {
            c.andMinAgeGreaterThanOrEqualTo(minAge);
        }

        Integer maxAge = (Integer) params.get("maxAge");
        if (maxAge != null) {
            c.andMaxAgeLessThan(maxAge);
        }

        return criteria;
    }
}
