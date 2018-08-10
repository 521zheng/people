package org.leesia.dataio.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.dao.HanziMapper;
import org.leesia.dataio.dao.ext.ExtHanziMapper;
import org.leesia.dataio.redis.RedisKeyPrefix;
import org.leesia.dataio.redis.RedisService;
import org.leesia.dataio.service.HanziService;
import org.leesia.entity.Hanzi;
import org.leesia.entity.HanziCriteria;
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
 * @Date: 2018/8/10 13:14
 * @Description:
 */
@Service("hanziService")
public class HanziServiceImpl implements HanziService {

    private static final Logger logger = LoggerFactory.getLogger(HanziServiceImpl.class);

    @Autowired
    private HanziMapper mapper;

    @Autowired
    private ExtHanziMapper extMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public int insert(Hanzi hanzi) {
        logger.info("增加常用汉字：{}", hanzi.getHanzi());
        if (StringUtils.isBlank(hanzi.getId())) {
            hanzi.setId(UUIDTools.uuid());
        }
        int insert = mapper.insertSelective(hanzi);
        redisService.setObject(RedisKeyPrefix.HanziPrefix.getPrefix() + hanzi.getHanzi(), hanzi, 60, TimeUnit.SECONDS);

        return insert;
    }

    @Override
    public int batchInsert(List<Hanzi> hanzis) {
        logger.info("批量增加常用汉字：{}", hanzis.size());
        if (hanzis.isEmpty()) {
            logger.error("批量增加常用汉字失败，没有要添加的常用汉字");
            return 0;
        }
        for (Hanzi hanzi : hanzis) {
            if (StringUtils.isBlank(hanzi.getId())) {
                hanzi.setId(UUIDTools.uuid());
            }
            if (hanzi.getCreateDatetime() == null) {
                hanzi.setCreateDatetime(new Date());
            }
            if (hanzi.getUpdateDatetime() == null) {
                hanzi.setUpdateDatetime(new Date());
            }
        }
        return extMapper.bacthInsert(hanzis);
    }

    @Override
    public List<Hanzi> get(Map<String, Object> params) {
        logger.info("查询常用汉字：{}", params);
        HanziCriteria criteria = createCriteria(params);
        return mapper.selectByExample(criteria);
    }

    @Override
    public Hanzi getByName(String hanziName) {
        logger.info("查询常用汉字：{}", hanziName);
        Hanzi hanzi = (Hanzi) redisService.getObject(RedisKeyPrefix.HanziPrefix.getPrefix() + hanziName);
        if (hanzi == null) {
            Map<String, Object> params = new HashMap<>();
            params.put("hanzi", hanziName);
            HanziCriteria criteria = createCriteria(params);
            List<Hanzi> hanzis = mapper.selectByExample(criteria);

            if (hanzis != null && !hanzis.isEmpty()) {
                hanzi = hanzis.get(0);
                redisService.setObject(RedisKeyPrefix.HanziPrefix.getPrefix() + hanziName, hanzi, 60, TimeUnit.SECONDS);
            }
        }

        return hanzi;
    }

    @Override
    public int delete(Hanzi hanzi) {
        logger.info("删除常用汉字：{}", hanzi.getId());
        if (StringUtils.isBlank(hanzi.getId())) {
            logger.error("删除常用汉字失败，主键为空");
            return 0;
        }
        int delete = mapper.deleteByPrimaryKey(hanzi.getId());
        redisService.deleteObject(RedisKeyPrefix.HanziPrefix.getPrefix() + hanzi.getHanzi());

        return delete;
    }

    @Override
    public int update(Hanzi hanzi) {
        logger.info("更新常用汉字：{}", hanzi.getId());
        if (StringUtils.isBlank(hanzi.getId())) {
            logger.error("更新常用汉字失败，主键为空");
            return 0;
        }
        int update = mapper.updateByPrimaryKeySelective(hanzi);
        redisService.setObject(RedisKeyPrefix.HanziPrefix.getPrefix() + hanzi.getHanzi(), hanzi, 60, TimeUnit.SECONDS);

        return update;
    }

    private HanziCriteria createCriteria(Map<String, Object> params) {
        HanziCriteria criteria = new HanziCriteria();
        HanziCriteria.Criteria c = criteria.createCriteria();

        String id = (String) params.get("id");
        if (StringUtils.isNotBlank(id)) {
            c.andIdEqualTo(id);
        }

        String hanzi = (String) params.get("hanzi");
        if (StringUtils.isNotBlank(hanzi)) {
            c.andHanziLike("%" + hanzi + "%");
        }

        return criteria;
    }
}
