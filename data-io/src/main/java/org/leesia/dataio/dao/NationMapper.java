package org.leesia.dataio.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.leesia.entity.Nation;
import org.leesia.entity.NationCriteria;

public interface NationMapper {
    long countByExample(NationCriteria example);

    int deleteByExample(NationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Nation record);

    int insertSelective(Nation record);

    List<Nation> selectByExample(NationCriteria example);

    Nation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Nation record, @Param("example") NationCriteria example);

    int updateByExample(@Param("record") Nation record, @Param("example") NationCriteria example);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);
}