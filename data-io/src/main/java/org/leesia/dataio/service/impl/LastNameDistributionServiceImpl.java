package org.leesia.dataio.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.dao.LastNameDistributionMapper;
import org.leesia.dataio.dao.ext.ExtLastNameDistributionMapper;
import org.leesia.dataio.service.LastNameDistributionService;
import org.leesia.entity.LastNameDistribution;
import org.leesia.entity.LastNameDistributionCriteria;
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
 * @Date: 2018/8/10 19:35
 * @Description:
 */
@Service("lastNameDistributionService")
public class LastNameDistributionServiceImpl implements LastNameDistributionService {

    private static final Logger logger = LoggerFactory.getLogger(LastNameDistributionServiceImpl.class);

    @Autowired
    private LastNameDistributionMapper mapper;

    @Autowired
    private ExtLastNameDistributionMapper extMapper;

    @Override
    public int insert(LastNameDistribution distribution) {
        logger.info("增加姓氏人口分布：{}", distribution.getLastName());
        if (StringUtils.isBlank(distribution.getId())) {
            distribution.setId(UUIDTool.uuid());
        }
        return mapper.insertSelective(distribution);
    }

    @Override
    public int batchInsert(List<LastNameDistribution> distributions) {
        logger.info("批量增加姓氏人口分布：{}", distributions.size());
        if (distributions.isEmpty()) {
            logger.error("批量增加姓氏人口分布失败，没有要添加的姓氏人口分布");
            return 0;
        }
        for (LastNameDistribution distribution : distributions) {
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
    public List<LastNameDistribution> get(Map<String, Object> params) {
        logger.info("查询姓氏人口分布：{}", params);
        LastNameDistributionCriteria criteria = createCriteria(params);
        return mapper.selectByExample(criteria);
    }

    @Override
    public LastNameDistribution getByLastName(String lastName) {
        logger.info("查询姓氏人口分布：{}", lastName);
        Map<String, Object> params = new HashMap<>();
        params.put("lastName", lastName);
        LastNameDistributionCriteria criteria = createCriteria(params);
        List<LastNameDistribution> distributions = mapper.selectByExample(criteria);

        if (distributions != null && !distributions.isEmpty()) {
            return distributions.get(0);
        }
        return null;
    }

    @Override
    public int delete(LastNameDistribution distribution) {
        logger.info("删除姓氏人口分布：{}", distribution.getId());
        if (StringUtils.isBlank(distribution.getId())) {
            logger.error("删除姓氏人口分布失败，主键为空");
            return 0;
        }
        return mapper.deleteByPrimaryKey(distribution.getId());
    }

    @Override
    public int update(LastNameDistribution distribution) {
        logger.info("更新姓氏人口分布：{}", distribution.getId());
        if (StringUtils.isBlank(distribution.getId())) {
            logger.error("更新姓氏人口分布失败，主键为空");
            return 0;
        }
        return mapper.updateByPrimaryKeySelective(distribution);
    }

    private LastNameDistributionCriteria createCriteria(Map<String, Object> params) {
        LastNameDistributionCriteria criteria = new LastNameDistributionCriteria();
        LastNameDistributionCriteria.Criteria c = criteria.createCriteria();

        String id = (String) params.get("id");
        if (StringUtils.isNotBlank(id)) {
            c.andIdEqualTo(id);
        }

        String lastName = (String) params.get("lastName");
        if (StringUtils.isNotBlank(lastName)) {
            c.andLastNameLike("%" + lastName + "%");
        }

        return criteria;
    }
}
