package org.leesia.dataio.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.leesia.entity.LastName;
import org.leesia.entity.LastNameCriteria;

public interface LastNameMapper {
    long countByExample(LastNameCriteria example);

    int deleteByExample(LastNameCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(LastName record);

    int insertSelective(LastName record);

    List<LastName> selectByExample(LastNameCriteria example);

    LastName selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LastName record, @Param("example") LastNameCriteria example);

    int updateByExample(@Param("record") LastName record, @Param("example") LastNameCriteria example);

    int updateByPrimaryKeySelective(LastName record);

    int updateByPrimaryKey(LastName record);
}