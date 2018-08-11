package org.leesia.dataio.dao.ext;

import org.leesia.entity.LastNameDistribution;

import java.util.List;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 12:59
 * @Description:
 */
public interface ExtLastNameDistributionMapper {

    int bacthInsert(List<LastNameDistribution> distributions);
}
