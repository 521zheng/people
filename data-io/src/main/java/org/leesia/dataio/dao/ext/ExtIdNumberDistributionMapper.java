package org.leesia.dataio.dao.ext;

import org.leesia.entity.IdNumberDistribution;

import java.util.List;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 12:59
 * @Description:
 */
public interface ExtIdNumberDistributionMapper {

    int bacthInsert(List<IdNumberDistribution> distributions);
}
