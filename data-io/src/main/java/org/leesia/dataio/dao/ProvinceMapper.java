package org.leesia.dataio.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.leesia.entity.Province;
import org.leesia.entity.ProvinceCriteria;

public interface ProvinceMapper {
    long countByExample(ProvinceCriteria example);

    int deleteByExample(ProvinceCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Province record);

    int insertSelective(Province record);

    List<Province> selectByExample(ProvinceCriteria example);

    Province selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Province record, @Param("example") ProvinceCriteria example);

    int updateByExample(@Param("record") Province record, @Param("example") ProvinceCriteria example);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}