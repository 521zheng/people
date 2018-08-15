package org.leesia.dataio.service;

import org.leesia.entity.ProvinceDistribution;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 16:41
 * @Description:
 */
public interface ProvinceDistributionService {

    int insert(ProvinceDistribution distribution);

    int batchInsert(List<ProvinceDistribution> distributions);

    List<ProvinceDistribution> get(Map<String, Object> params);

    ProvinceDistribution getByProvince(String provinceName);

    int delete(ProvinceDistribution distribution);

    int update(ProvinceDistribution distribution);
}
