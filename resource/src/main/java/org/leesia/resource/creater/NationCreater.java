package org.leesia.resource.creater;

import org.leesia.dataio.service.NationDistributionService;
import org.leesia.entity.NationDistribution;
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

/**
 * @Auther: leesia
 * @Date: 2018/8/16 13:27
 * @Description:
 */
@Service
public class NationCreater {

    private static final Logger logger = LoggerFactory.getLogger(NationCreater.class);

    @Autowired
    private NationDistributionService nationDistributionService;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private RedisService redisService;

    public String creater() {
        NDistribution nDistribution = distribution();
        double random = Math.random();
        double[] distribution = nDistribution.getDistribution();
        int index = 0;
        for (; index < distribution.length; index++) {
            if (random < distribution[index]) {
                break;
            }
        }
        String[] nations = nDistribution.getNations();
        if (index < distribution.length) {
            return nations[index];
        }
        return nations[nations.length - 1];
    }

    private NDistribution distribution() {
        NDistribution nDistribution = (NDistribution) redisService.getObject(RedisKeyPrefix.NationDistributionPrefix.getPrefix());
        if (nDistribution != null) {
            return nDistribution;
        }
        List<NationDistribution> distributions = nationDistributionService.get(new HashMap<>());
        double[] distribution = new double[distributions.size()];
        String[] nations = new String[distributions.size()];
        double dis = 0;
        for (int i = 0; i < distributions.size(); i++) {
            NationDistribution nd = distributions.get(i);
            dis += nd.getDistribution();
            distribution[i] = dis;
            nations[i] = nd.getNationName();
        }
        nDistribution = new NDistribution();
        nDistribution.setDistribution(distribution);
        nDistribution.setNations(nations);

        redisService.setObject(RedisKeyPrefix.NationDistributionPrefix.getPrefix(), nDistribution);

        return nDistribution;
    }

    static class NDistribution implements Serializable {
        private double[] distribution;
        private String[] nations;

        public double[] getDistribution() {
            return distribution;
        }

        public void setDistribution(double[] distribution) {
            this.distribution = distribution;
        }

        public String[] getNations() {
            return nations;
        }

        public void setNations(String[] nations) {
            this.nations = nations;
        }
    }
}
