package org.leesia.dataio.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.leesia.entity.LastNameDistribution;
import org.leesia.entity.LastNameDistributionCriteria;

public interface LastNameDistributionMapper {
    long countByExample(LastNameDistributionCriteria example);

    int deleteByExample(LastNameDistributionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(LastNameDistribution record);

    int insertSelective(LastNameDistribution record);

    List<LastNameDistribution> selectByExample(LastNameDistributionCriteria example);

    LastNameDistribution selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LastNameDistribution record, @Param("example") LastNameDistributionCriteria example);

    int updateByExample(@Param("record") LastNameDistribution record, @Param("example") LastNameDistributionCriteria example);

    int updateByPrimaryKeySelective(LastNameDistribution record);

    int updateByPrimaryKey(LastNameDistribution record);
}