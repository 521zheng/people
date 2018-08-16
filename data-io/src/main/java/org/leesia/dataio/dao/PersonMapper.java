package org.leesia.dataio.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.leesia.entity.Person;
import org.leesia.entity.PersonCriteria;

public interface PersonMapper {
    long countByExample(PersonCriteria example);

    int deleteByExample(PersonCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Person record);

    int insertSelective(Person record);

    List<Person> selectByExample(PersonCriteria example);

    Person selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonCriteria example);

    int updateByExample(@Param("record") Person record, @Param("example") PersonCriteria example);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}