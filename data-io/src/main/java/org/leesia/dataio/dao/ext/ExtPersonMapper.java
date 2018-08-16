package org.leesia.dataio.dao.ext;

import org.leesia.entity.Person;

import java.util.List;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 12:59
 * @Description:
 */
public interface ExtPersonMapper {

    int bacthInsert(List<Person> list);
}
