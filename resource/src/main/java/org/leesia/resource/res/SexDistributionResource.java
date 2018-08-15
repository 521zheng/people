package org.leesia.resource.res;

import org.leesia.dataio.service.SexDistributionService;
import org.leesia.entity.SexDistribution;
import org.leesia.enums.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 13:00
 * @Description:
 */
@Service
public class SexDistributionResource {

    @Autowired
    private SexDistributionService sexDistributionService;

    public void insertAllSexDistribution() {
        SexDistribution male = new SexDistribution();
        male.setSex(Sex.MALE.getSex());
        male.setDistribution(0.519);
        SexDistribution female = new SexDistribution();
        female.setSex(Sex.FEMALE.getSex());
        female.setDistribution(0.481);

        sexDistributionService.insert(male);
        sexDistributionService.insert(female);
    }
}
