package org.leesia.dataio.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.dao.PersonMapper;
import org.leesia.dataio.dao.ext.ExtPersonMapper;
import org.leesia.dataio.service.PersonService;
import org.leesia.entity.Person;
import org.leesia.entity.PersonCriteria;
import org.leesia.util.UUIDTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/16 08:29
 * @Description:
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonMapper mapper;

    @Autowired
    private ExtPersonMapper extMapper;

    @Override
    public int insert(Person person) {
        logger.info("增加个人信息：{}", person.getName());
        if (StringUtils.isBlank(person.getId())) {
            person.setId(UUIDTool.uuid());
        }
        return mapper.insertSelective(person);
    }

    @Override
    public int batchInsert(List<Person> list) {
        logger.info("批量增加个人信息：{}", list.size());
        if (list.isEmpty()) {
            logger.error("批量增加个人信息失败，没有要添加的个人信息");
            return 0;
        }
        for (Person person : list) {
            if (StringUtils.isBlank(person.getId())) {
                person.setId(UUIDTool.uuid());
            }
            if (person.getCreateDatetime() == null) {
                person.setCreateDatetime(new Date());
            }
            if (person.getUpdateDatetime() == null) {
                person.setUpdateDatetime(new Date());
            }
        }
        return extMapper.bacthInsert(list);
    }

    @Override
    public List<Person> get(Map<String, Object> params) {
        logger.info("查询个人信息：{}", params);
        PersonCriteria criteria = createCriteria(params);
        return mapper.selectByExample(criteria);
    }

    @Override
    public int delete(Person person) {
        logger.info("删除个人信息：{}", person.getId());
        if (StringUtils.isBlank(person.getId())) {
            logger.error("删除个人信息失败，主键为空");
            return 0;
        }
        return mapper.deleteByPrimaryKey(person.getId());
    }

    @Override
    public int update(Person person) {
        logger.info("更新个人信息：{}", person.getId());
        if (StringUtils.isBlank(person.getId())) {
            logger.error("更新个人信息失败，主键为空");
            return 0;
        }
        return mapper.updateByPrimaryKeySelective(person);
    }

    private PersonCriteria createCriteria(Map<String, Object> params) {
        PersonCriteria criteria = new PersonCriteria();
        PersonCriteria.Criteria c = criteria.createCriteria();

        String id = (String) params.get("id");
        if (StringUtils.isNotBlank(id)) {
            c.andIdEqualTo(id);
        }

        String name = (String) params.get("name");
        if (StringUtils.isNotBlank(name)) {
            c.andNameLike("%" + name + "%");
        }

        Integer sex = (Integer) params.get("sex");
        if (sex != null) {
            c.andSexEqualTo(sex);
        }

        String nation = (String) params.get("nation");
        if (StringUtils.isNotBlank(nation)) {
            c.andNationLike("%" + nation + "%");
        }

        String registerProvince = (String) params.get("registerProvince");
        if (StringUtils.isNotBlank(registerProvince)) {
            c.andRegisterProvinceLike("%" + registerProvince + "%");
        }

        String registerCity = (String) params.get("registerCity");
        if (StringUtils.isNotBlank(registerCity)) {
            c.andRegisterCityLike("%" + registerCity + "%");
        }

        String liveProvince = (String) params.get("liveProvince");
        if (StringUtils.isNotBlank(liveProvince)) {
            c.andLiveProvinceLike("%" + liveProvince + "%");
        }

        String liveCity = (String) params.get("liveCity");
        if (StringUtils.isNotBlank(liveCity)) {
            c.andLiveCityLike("%" + liveCity + "%");
        }

        return criteria;
    }
}
