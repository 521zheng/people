package org.leesia.dataio.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.leesia.entity.AgeDistribution;
import org.leesia.entity.AgeDistributionCriteria;

public interface AgeDistributionMapper {
    long countByExample(AgeDistributionCriteria example);

    int deleteByExample(AgeDistributionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(AgeDistribution record);

    int insertSelective(AgeDistribution record);

    List<AgeDistribution> selectByExample(AgeDistributionCriteria example);

    AgeDistribution selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AgeDistribution record, @Param("example") AgeDistributionCriteria example);

    int updateByExample(@Param("record") AgeDistribution record, @Param("example") AgeDistributionCriteria example);

    int updateByPrimaryKeySelective(AgeDistribution record);

    int updateByPrimaryKey(AgeDistribution record);
}