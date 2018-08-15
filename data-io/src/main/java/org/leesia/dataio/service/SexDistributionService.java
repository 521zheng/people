package org.leesia.dataio.service;

import org.leesia.entity.SexDistribution;
import org.leesia.enums.Sex;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 12:46
 * @Description:
 */
public interface SexDistributionService {

    int insert(SexDistribution distribution);

    List<SexDistribution> get(Map<String, Object> params);

    SexDistribution getBySex(int sex);

    int delete(SexDistribution distribution);

    int update(SexDistribution distribution);
}
