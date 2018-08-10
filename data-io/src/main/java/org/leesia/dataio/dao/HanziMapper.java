package org.leesia.dataio.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.leesia.entity.Hanzi;
import org.leesia.entity.HanziCriteria;

public interface HanziMapper {
    long countByExample(HanziCriteria example);

    int deleteByExample(HanziCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Hanzi record);

    int insertSelective(Hanzi record);

    List<Hanzi> selectByExample(HanziCriteria example);

    Hanzi selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Hanzi record, @Param("example") HanziCriteria example);

    int updateByExample(@Param("record") Hanzi record, @Param("example") HanziCriteria example);

    int updateByPrimaryKeySelective(Hanzi record);

    int updateByPrimaryKey(Hanzi record);
}