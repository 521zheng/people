package org.leesia.dataio.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.leesia.entity.ProvinceDistribution;
import org.leesia.entity.ProvinceDistributionCriteria;

public interface ProvinceDistributionMapper {
    long countByExample(ProvinceDistributionCriteria example);

    int deleteByExample(ProvinceDistributionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(ProvinceDistribution record);

    int insertSelective(ProvinceDistribution record);

    List<ProvinceDistribution> selectByExample(ProvinceDistributionCriteria example);

    ProvinceDistribution selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProvinceDistribution record, @Param("example") ProvinceDistributionCriteria example);

    int updateByExample(@Param("record") ProvinceDistribution record, @Param("example") ProvinceDistributionCriteria example);

    int updateByPrimaryKeySelective(ProvinceDistribution record);

    int updateByPrimaryKey(ProvinceDistribution record);
}