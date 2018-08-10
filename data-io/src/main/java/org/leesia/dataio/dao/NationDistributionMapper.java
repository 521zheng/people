package org.leesia.dataio.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.leesia.entity.NationDistribution;
import org.leesia.entity.NationDistributionCriteria;

public interface NationDistributionMapper {
    long countByExample(NationDistributionCriteria example);

    int deleteByExample(NationDistributionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(NationDistribution record);

    int insertSelective(NationDistribution record);

    List<NationDistribution> selectByExample(NationDistributionCriteria example);

    NationDistribution selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") NationDistribution record, @Param("example") NationDistributionCriteria example);

    int updateByExample(@Param("record") NationDistribution record, @Param("example") NationDistributionCriteria example);

    int updateByPrimaryKeySelective(NationDistribution record);

    int updateByPrimaryKey(NationDistribution record);
}