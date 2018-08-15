package org.leesia.dataio.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.leesia.entity.SexDistribution;
import org.leesia.entity.SexDistributionCriteria;

public interface SexDistributionMapper {
    long countByExample(SexDistributionCriteria example);

    int deleteByExample(SexDistributionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SexDistribution record);

    int insertSelective(SexDistribution record);

    List<SexDistribution> selectByExample(SexDistributionCriteria example);

    SexDistribution selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SexDistribution record, @Param("example") SexDistributionCriteria example);

    int updateByExample(@Param("record") SexDistribution record, @Param("example") SexDistributionCriteria example);

    int updateByPrimaryKeySelective(SexDistribution record);

    int updateByPrimaryKey(SexDistribution record);
}