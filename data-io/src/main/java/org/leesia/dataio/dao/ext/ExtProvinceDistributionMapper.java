package org.leesia.dataio.dao.ext;

import org.leesia.entity.ProvinceDistribution;

import java.util.List;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 12:59
 * @Description:
 */
public interface ExtProvinceDistributionMapper {

    int bacthInsert(List<ProvinceDistribution> distributions);
}
