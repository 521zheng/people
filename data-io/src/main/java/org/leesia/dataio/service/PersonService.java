package org.leesia.dataio.service;

import org.leesia.entity.Nation;
import org.leesia.entity.Person;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/16 08:27
 * @Description:
 */
public interface PersonService {

    int insert(Person person);

    int batchInsert(List<Person> list);

    List<Person> get(Map<String, Object> params);

    int delete(Person person);

    int update(Person person);
}
