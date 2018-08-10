package org.leesia.dataio.dao.ext;

import org.leesia.entity.Nation;
import org.leesia.entity.NationDistribution;

import java.util.List;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 12:59
 * @Description:
 */
public interface ExtNationDistributionMapper {

    int bacthInsert(List<NationDistribution> distributions);
}
