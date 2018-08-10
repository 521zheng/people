package org.leesia.dataio.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.dao.ext.ExtNationMapper;
import org.leesia.dataio.dao.NationMapper;
import org.leesia.dataio.redis.RedisKeyPrefix;
import org.leesia.dataio.redis.RedisService;
import org.leesia.dataio.service.NationService;
import org.leesia.entity.Nation;
import org.leesia.entity.NationCriteria;
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
 * @Date: 2018/8/9 14:29
 * @Description:
 */
@Service("nationService")
public class NationServiceImpl implements NationService {

    private static final Logger logger = LoggerFactory.getLogger(NationServiceImpl.class);

    @Autowired
    private NationMapper mapper;

    @Autowired
    private ExtNationMapper extMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public int insert(Nation nation) {
        logger.info("增加民族：{}", nation.getNationName());
        if (StringUtils.isBlank(nation.getId())) {
            nation.setId(UUIDTools.uuid());
        }
        int insert = mapper.insertSelective(nation);
        redisService.setObject(RedisKeyPrefix.NationPrefix.getPrefix() + nation.getNationName(), nation, 60, TimeUnit.SECONDS);

        return insert;
    }

    @Override
    public int batchInsert(List<Nation> nations) {
        logger.info("批量增加民族：{}", nations.size());
        if (nations.isEmpty()) {
            logger.error("批量增加民族失败，没有要添加的民族");
            return 0;
        }
        for (Nation nation : nations) {
            if (StringUtils.isBlank(nation.getId())) {
                nation.setId(UUIDTools.uuid());
            }
            if (nation.getCreateDatetime() == null) {
                nation.setCreateDatetime(new Date());
            }
            if (nation.getUpdateDatetime() == null) {
                nation.setUpdateDatetime(new Date());
            }
        }
        return extMapper.bacthInsert(nations);
    }

    @Override
    public List<Nation> get(Map<String, Object> params) {
        logger.info("查询民族：{}", params);
        NationCriteria criteria = createCriteria(params);
        return mapper.selectByExample(criteria);
    }

    @Override
    public Nation getByName(String nationName) {
        logger.info("查询民族：{}", nationName);
        Nation nation = (Nation) redisService.getObject(RedisKeyPrefix.NationPrefix.getPrefix() + nationName);
        if (nation == null) {
            Map<String, Object> params = new HashMap<>();
            params.put("nationName", nationName);
            NationCriteria criteria = createCriteria(params);
            List<Nation> nations = mapper.selectByExample(criteria);

            if (nations != null && !nations.isEmpty()) {
                nation = nations.get(0);
                redisService.setObject(RedisKeyPrefix.NationPrefix.getPrefix() + nationName, nation, 60, TimeUnit.SECONDS);
            }
        }

        return nation;
    }

    @Override
    public int delete(Nation nation) {
        logger.info("删除民族：{}", nation.getId());
        if (StringUtils.isBlank(nation.getId())) {
            logger.error("删除民族失败，主键为空");
            return 0;
        }
        int delete = mapper.deleteByPrimaryKey(nation.getId());
        redisService.deleteObject(RedisKeyPrefix.NationPrefix.getPrefix() + nation.getNationName());

        return delete;
    }

    @Override
    public int update(Nation nation) {
        logger.info("更新民族：{}", nation.getId());
        if (StringUtils.isBlank(nation.getId())) {
            logger.error("更新民族失败，主键为空");
            return 0;
        }
        int update = mapper.updateByPrimaryKeySelective(nation);
        redisService.setObject(RedisKeyPrefix.NationPrefix.getPrefix() + nation.getNationName(), nation, 60, TimeUnit.SECONDS);

        return update;
    }

    private NationCriteria createCriteria(Map<String, Object> params) {
        NationCriteria criteria = new NationCriteria();
        NationCriteria.Criteria c = criteria.createCriteria();

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
