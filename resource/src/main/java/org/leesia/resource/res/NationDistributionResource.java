package org.leesia.resource.res;

import org.leesia.dataio.service.NationDistributionService;
import org.leesia.entity.City;
import org.leesia.entity.NationDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/9 20:56
 * @Description:
 */
@Service
public class NationDistributionResource {

    private Map<String, Double> NATION_DISTRIBUTION = new HashMap<>();

    @Autowired
    private NationDistributionService nationDistributionService;

    private List<NationDistribution> createAllNationDistribution() {
        List<NationDistribution> distributions = new ArrayList<>();
        for (Map.Entry<String, Double> entry : NATION_DISTRIBUTION.entrySet()) {
            NationDistribution distribution = new NationDistribution();
            distribution.setNationName(entry.getKey());
            distribution.setDistribution(entry.getValue());

            distributions.add(distribution);
        }
        return distributions;
    }

    public void insertAllNationDistribution() {
        nationDistributionService.batchInsert(createAllNationDistribution());
    }
}
