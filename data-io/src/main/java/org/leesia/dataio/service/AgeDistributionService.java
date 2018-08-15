package org.leesia.dataio.service;

import org.leesia.entity.AgeDistribution;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 13:22
 * @Description:
 */
public interface AgeDistributionService {

    int insert(AgeDistribution distribution);

    List<AgeDistribution> get(Map<String, Object> params);

    AgeDistribution getByAge(int age);

    int delete(AgeDistribution distribution);

    int update(AgeDistribution distribution);
}
