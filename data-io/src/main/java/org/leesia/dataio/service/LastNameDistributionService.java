package org.leesia.dataio.service;

import org.leesia.entity.LastNameDistribution;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/10 19:34
 * @Description:
 */
public interface LastNameDistributionService {

    int insert(LastNameDistribution distribution);

    int batchInsert(List<LastNameDistribution> distributions);

    List<LastNameDistribution> get(Map<String, Object> params);

    LastNameDistribution getByLastName(String lastName);

    int delete(LastNameDistribution distribution);

    int update(LastNameDistribution distribution);
}
