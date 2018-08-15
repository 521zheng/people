package org.leesia.resource.res;

import org.leesia.dataio.service.AgeDistributionService;
import org.leesia.entity.AgeDistribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 13:00
 * @Description:
 */
@Service
public class AgeDistributionResource {

    @Autowired
    private AgeDistributionService ageDistributionService;

    public void insertAllAgeDistribution() {
        AgeDistribution d1 = new AgeDistribution();
        d1.setMinAge(0);
        d1.setMaxAge(16);
        d1.setDistribution(0.178);

        AgeDistribution d2 = new AgeDistribution();
        d2.setMinAge(16);
        d2.setMaxAge(60);
        d2.setDistribution(0.649);

        AgeDistribution d3 = new AgeDistribution();
        d3.setMinAge(60);
        d3.setMaxAge(null);
        d3.setDistribution(0.173);

        ageDistributionService.insert(d1);
        ageDistributionService.insert(d2);
        ageDistributionService.insert(d3);
    }
}
