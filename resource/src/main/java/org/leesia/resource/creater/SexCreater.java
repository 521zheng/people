package org.leesia.resource.creater;

import org.leesia.dataio.service.NationDistributionService;
import org.leesia.dataio.service.SexDistributionService;
import org.leesia.entity.NationDistribution;
import org.leesia.entity.SexDistribution;
import org.leesia.resource.config.RedisConfig;
import org.leesia.resource.redis.RedisKeyPrefix;
import org.leesia.resource.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/16 13:51
 * @Description:
 */
@Service
public class SexCreater {

    private static final Logger logger = LoggerFactory.getLogger(SexCreater.class);

    @Autowired
    private SexDistributionService sexDistributionService;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private RedisService redisService;

    public int creater() {
        SDistribution sDistribution = distribution();
        double random = Math.random();
        double[] distribution = sDistribution.getDistribution();
        int index = 0;
        for (; index < distribution.length; index++) {
            if (random < distribution[index]) {
                break;
            }
        }
        int[] sex = sDistribution.getSex();
        if (index < distribution.length) {
            return sex[index];
        }
        return sex[sex.length - 1];
    }

    private SDistribution distribution() {
        SDistribution sDistribution = (SDistribution) redisService.getObject(RedisKeyPrefix.SexDistributionPrefix.getPrefix());
        if (sDistribution != null) {
            return sDistribution;
        }
        List<SexDistribution> distributions = sexDistributionService.get(new HashMap<>());
        double[] distribution = new double[distributions.size()];
        int[] sex = new int[distributions.size()];
        double dis = 0;
        for (int i = 0; i < distributions.size(); i++) {
            SexDistribution nd = distributions.get(i);
            dis += nd.getDistribution();
            distribution[i] = dis;
            sex[i] = nd.getSex();
        }
        sDistribution = new SDistribution();
        sDistribution.setDistribution(distribution);
        sDistribution.setSex(sex);

        redisService.setObject(RedisKeyPrefix.SexDistributionPrefix.getPrefix(), sDistribution);

        return sDistribution;
    }

    static class SDistribution implements Serializable {
        private double[] distribution;
        private int[] sex;

        public double[] getDistribution() {
            return distribution;
        }

        public void setDistribution(double[] distribution) {
            this.distribution = distribution;
        }

        public int[] getSex() {
            return sex;
        }

        public void setSex(int[] sex) {
            this.sex = sex;
        }
    }
}
