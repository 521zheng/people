package org.leesia.dataio.service;

import org.leesia.entity.NationDistribution;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/10 13:47
 * @Description:
 */
public interface NationDistributionService {

    int insert(NationDistribution distribution);

    int batchInsert(List<NationDistribution> distributions);

    List<NationDistribution> get(Map<String, Object> params);

    NationDistribution getByNation(String nationName);

    int delete(NationDistribution distribution);

    int update(NationDistribution distribution);
}
