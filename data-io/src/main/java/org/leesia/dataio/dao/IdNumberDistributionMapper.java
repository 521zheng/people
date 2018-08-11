package org.leesia.dataio.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.leesia.entity.IdNumberDistribution;
import org.leesia.entity.IdNumberDistributionCriteria;

public interface IdNumberDistributionMapper {
    long countByExample(IdNumberDistributionCriteria example);

    int deleteByExample(IdNumberDistributionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(IdNumberDistribution record);

    int insertSelective(IdNumberDistribution record);

    List<IdNumberDistribution> selectByExample(IdNumberDistributionCriteria example);

    IdNumberDistribution selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") IdNumberDistribution record, @Param("example") IdNumberDistributionCriteria example);

    int updateByExample(@Param("record") IdNumberDistribution record, @Param("example") IdNumberDistributionCriteria example);

    int updateByPrimaryKeySelective(IdNumberDistribution record);

    int updateByPrimaryKey(IdNumberDistribution record);
}