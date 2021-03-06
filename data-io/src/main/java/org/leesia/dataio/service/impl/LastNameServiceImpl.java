package org.leesia.dataio.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.dao.ext.ExtLastNameMapper;
import org.leesia.dataio.dao.LastNameMapper;
import org.leesia.dataio.service.LastNameService;
import org.leesia.entity.LastName;
import org.leesia.entity.LastNameCriteria;
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
 * @Date: 2018/8/9 09:03
 * @Description:
 */
@Service("lastNameService")
public class LastNameServiceImpl implements LastNameService {

    private static final Logger logger = LoggerFactory.getLogger(LastNameServiceImpl.class);

    @Autowired
    private LastNameMapper mapper;

    @Autowired
    private ExtLastNameMapper extMapper;

    @Override
    public int insert(LastName lastName) {
        logger.info("增加姓氏：{}", lastName.getLastName());
        if (StringUtils.isBlank(lastName.getId())) {
            lastName.setId(UUIDTool.uuid());
        }
        return mapper.insertSelective(lastName);
    }

    @Override
    public int batchInsert(List<LastName> lastNames) {
        logger.info("批量增加姓氏：{}", lastNames.size());
        if (lastNames.isEmpty()) {
            logger.error("批量增加姓氏失败，没有要添加的姓氏");
            return 0;
        }
        for (LastName lastName : lastNames) {
            if (StringUtils.isBlank(lastName.getId())) {
                lastName.setId(UUIDTool.uuid());
            }
            if (lastName.getCreateDatetime() == null) {
                lastName.setCreateDatetime(new Date());
            }
            if (lastName.getUpdateDatetime() == null) {
                lastName.setUpdateDatetime(new Date());
            }
        }
        return extMapper.bacthInsert(lastNames);
    }

    @Override
    public List<LastName> get(Map<String, Object> params) {
        logger.info("查询姓氏：{}", params);
        LastNameCriteria criteria = createCriteria(params);
        return mapper.selectByExample(criteria);
    }

    @Override
    public LastName getByName(String lastName) {
        logger.info("查询姓氏：{}", lastName);
        Map<String, Object> params = new HashMap<>();
        params.put("lastName", lastName);
        LastNameCriteria criteria = createCriteria(params);
        List<LastName> lastNames = mapper.selectByExample(criteria);

        if (lastNames != null && !lastNames.isEmpty()) {
            return lastNames.get(0);
        }
        return null;
    }

    @Override
    public int delete(LastName lastName) {
        logger.info("删除姓氏：{}", lastName.getId());
        if (StringUtils.isBlank(lastName.getId())) {
            logger.error("删除姓氏失败，主键为空");
            return 0;
        }
        return mapper.deleteByPrimaryKey(lastName.getId());
    }

    @Override
    public int update(LastName lastName) {
        logger.info("更新姓氏：{}", lastName.getId());
        if (StringUtils.isBlank(lastName.getId())) {
            logger.error("更新姓氏失败，主键为空");
            return 0;
        }
        return mapper.updateByPrimaryKeySelective(lastName);
    }

    private LastNameCriteria createCriteria(Map<String, Object> params) {
        LastNameCriteria criteria = new LastNameCriteria();
        LastNameCriteria.Criteria c = criteria.createCriteria();

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
