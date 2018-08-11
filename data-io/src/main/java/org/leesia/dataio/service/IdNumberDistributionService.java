package org.leesia.dataio.service;

import org.leesia.entity.IdNumberDistribution;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/11 11:59
 * @Description:
 */
public interface IdNumberDistributionService {

    int insert(IdNumberDistribution distribution);

    int batchInsert(List<IdNumberDistribution> distributions);

    List<IdNumberDistribution> get(Map<String, Object> params);

    IdNumberDistribution getByProvince(String provinceName);

    int delete(IdNumberDistribution distribution);

    int update(IdNumberDistribution distribution);
}
