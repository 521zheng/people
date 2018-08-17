package org.leesia.resource.creater;

import org.leesia.dataio.service.AgeDistributionService;
import org.leesia.dataio.service.IdNumberDistributionService;
import org.leesia.entity.AgeDistribution;
import org.leesia.entity.NationDistribution;
import org.leesia.resource.config.RedisConfig;
import org.leesia.resource.redis.RedisKeyPrefix;
import org.leesia.resource.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @Auther: leesia
 * @Date: 2018/8/17 12:57
 * @Description:
 */
@Service
public class BirthdayCreater {

    @Autowired
    private AgeDistributionService ageDistributionService;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private RedisService redisService;

    public String creater() {
        int age = getAge();
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), 0, 1);
        calendar.add(Calendar.YEAR, -age);
        int day = new Random().nextInt(365);
        calendar.add(Calendar.DATE, day);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);

        String birthday = "" + year + "-" + (month < 10 ? "0" : "") + month + "-" + (date < 10 ? "0" : "") + date;
        return birthday;
    }

    private int getAge() {
        ADistribution aDistribution = distribution();
        double random = Math.random();
        double[] distribution = aDistribution.getDistribution();
        int index = 0;
        for (; index < distribution.length; index++) {
            if (random < distribution[index]) {
                break;
            }
        }
        AgeDistribution[] ageDistributions = aDistribution.getAgeDistributions();
        AgeDistribution ageDistribution = null;
        if (index < distribution.length) {
            ageDistribution = ageDistributions[index];
        }
        int from = 0;
        int length = 0;
        if (ageDistribution != null) {
            from = ageDistribution.getMinAge();
            length = ageDistribution.getMaxAge() - ageDistribution.getMinAge() - 1;
        } else {
            from = 100;
            length = 20;
        }
        int age = from + new Random().nextInt(length);
        return age;
    }

    private ADistribution distribution() {
        ADistribution aDistribution = (ADistribution) redisService.getObject(RedisKeyPrefix.AgeDistributionPrefix.getPrefix());
        if (aDistribution != null) {
            return aDistribution;
        }
        List<AgeDistribution> distributions = ageDistributionService.get(new HashMap<>());
        double[] distribution = new double[distributions.size()];
        AgeDistribution[] ageDistributions = new AgeDistribution[distributions.size()];
        double dis = 0;
        for (int i = 0; i < distributions.size(); i++) {
            AgeDistribution ad = distributions.get(i);
            dis += ad.getDistribution();
            distribution[i] = dis;
            ageDistributions[i] = ad;
        }
        aDistribution = new ADistribution();
        aDistribution.setDistribution(distribution);
        aDistribution.setAgeDistributions(ageDistributions);

        redisService.setObject(RedisKeyPrefix.AgeDistributionPrefix.getPrefix(), aDistribution);

        return aDistribution;
    }

    static class ADistribution implements Serializable {
        private double[] distribution;
        private AgeDistribution[] ageDistributions;

        public double[] getDistribution() {
            return distribution;
        }

        public void setDistribution(double[] distribution) {
            this.distribution = distribution;
        }

        public AgeDistribution[] getAgeDistributions() {
            return ageDistributions;
        }

        public void setAgeDistributions(AgeDistribution[] ageDistributions) {
            this.ageDistributions = ageDistributions;
        }
    }
}
