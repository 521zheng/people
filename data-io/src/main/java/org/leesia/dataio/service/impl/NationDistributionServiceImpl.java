package org.leesia.dataio.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.dao.NationDistributionMapper;
import org.leesia.dataio.dao.ext.ExtNationDistributionMapper;
import org.leesia.dataio.service.NationDistributionService;
import org.leesia.entity.NationDistribution;
import org.leesia.entity.NationDistributionCriteria;
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
 * @Date: 2018/8/10 13:47
 * @Description:
 */
@Service("nationDistributionService")
public class NationDistributionServiceImpl implements NationDistributionService {

    private static final Logger logger = LoggerFactory.getLogger(NationDistributionServiceImpl.class);

    @Autowired
    private NationDistributionMapper mapper;

    @Autowired
    private ExtNationDistributionMapper extMapper;

    @Override
    public int insert(NationDistribution distribution) {
        logger.info("增加民族人口分布：{}", distribution.getNationName());
        if (StringUtils.isBlank(distribution.getId())) {
            distribution.setId(UUIDTool.uuid());
        }
        return mapper.insertSelective(distribution);
    }

    @Override
    public int batchInsert(List<NationDistribution> distributions) {
        logger.info("批量增加民族人口分布：{}", distributions.size());
        if (distributions.isEmpty()) {
            logger.error("批量增加民族人口分布失败，没有要添加的民族人口分布");
            return 0;
        }
        for (NationDistribution distribution : distributions) {
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
    public List<NationDistribution> get(Map<String, Object> params) {
        logger.info("查询民族人口分布：{}", params);
        NationDistributionCriteria criteria = createCriteria(params);
        return mapper.selectByExample(criteria);
    }

    @Override
    public NationDistribution getByNation(String nationName) {
        logger.info("查询民族人口分布：{}", nationName);
        Map<String, Object> params = new HashMap<>();
        params.put("nationName", nationName);
        NationDistributionCriteria criteria = createCriteria(params);
        List<NationDistribution> distributions = mapper.selectByExample(criteria);

        if (distributions != null && !distributions.isEmpty()) {
            return distributions.get(0);
        }
        return null;
    }

    @Override
    public int delete(NationDistribution distribution) {
        logger.info("删除民族人口分布：{}", distribution.getId());
        if (StringUtils.isBlank(distribution.getId())) {
            logger.error("删除民族人口分布失败，主键为空");
            return 0;
        }
        return mapper.deleteByPrimaryKey(distribution.getId());
    }

    @Override
    public int update(NationDistribution distribution) {
        logger.info("更新民族人口分布：{}", distribution.getId());
        if (StringUtils.isBlank(distribution.getId())) {
            logger.error("更新民族人口分布失败，主键为空");
            return 0;
        }
        return mapper.updateByPrimaryKeySelective(distribution);
    }

    private NationDistributionCriteria createCriteria(Map<String, Object> params) {
        NationDistributionCriteria criteria = new NationDistributionCriteria();
        NationDistributionCriteria.Criteria c = criteria.createCriteria();

        String id = (String) params.get("id");
        if (StringUtils.isNotBlank(id)) {
            c.andIdEqualTo(id);
        }

        String nationName = (String) params.get("nationName");
        if (StringUtils.isNotBlank(nationName)) {
            c.andNationNameLike("%" + nationName + "%");
        }

        return criteria;
    }
}
