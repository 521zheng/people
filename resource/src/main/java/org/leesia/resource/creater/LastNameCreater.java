package org.leesia.resource.creater;

import org.leesia.dataio.service.LastNameDistributionService;
import org.leesia.dataio.service.LastNameService;
import org.leesia.entity.LastName;
import org.leesia.entity.LastNameDistribution;
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
import java.util.Random;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 23:35
 * @Description:
 */
@Service
public class LastNameCreater {

    private static final Logger logger = LoggerFactory.getLogger(LastNameCreater.class);

    @Autowired
    private LastNameService lastNameService;

    @Autowired
    private LastNameDistributionService lastNameDistributionService;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private RedisService redisService;

    public String creater() {
        LNDistribution lnDistribution = distribution();
        double random = Math.random();
        double[] disTop100 = lnDistribution.getDisTop100();
        int index = 0;
        for (; index < disTop100.length; index++) {
            if (random < disTop100[index]) {
                break;
            }
        }
        if (index < disTop100.length) {
            return lnDistribution.getLnTop100()[index];
        } else {
            String[] otherln = lnDistribution.getOtherln();
            int rand = new Random().nextInt(otherln.length);
            return otherln[rand];
        }
    }

    private LNDistribution distribution() {
        LNDistribution lnDistribution = (LNDistribution) redisService.getObject(RedisKeyPrefix.LastNameDistributionPrefix.getPrefix());
        if (lnDistribution != null) {
            return lnDistribution;
        }
        List<LastNameDistribution> distributions = lastNameDistributionService.get(new HashMap<>());
        List<LastName> lastNames = lastNameService.get(new HashMap<>());
        double[] disTop100 = new double[distributions.size()];
        String[] lnTop100 = new String[distributions.size()];
        Map<String, String> map = new HashMap<>();
        double dis = 0;
        for (int i = 0; i < distributions.size(); i++) {
            LastNameDistribution lnd = distributions.get(i);
            dis += lnd.getDistribution();
            disTop100[i] = dis;
            lnTop100[i] = lnd.getLastName();
            map.put(lnd.getLastName(), lnd.getLastName());
        }
        String[] otherln = new String[lastNames.size() - distributions.size()];
        int index = 0;
        for (int i = 0; i < lastNames.size(); i++) {
            if (map.get(lastNames.get(i).getLastName()) == null) {
                otherln[index++] = lastNames.get(i).getLastName();
            }
        }
        lnDistribution = new LNDistribution();
        lnDistribution.setDisTop100(disTop100);
        lnDistribution.setLnTop100(lnTop100);
        lnDistribution.setOtherln(otherln);

        redisService.setObject(RedisKeyPrefix.LastNameDistributionPrefix.getPrefix(), lnDistribution);

        return lnDistribution;
    }

    static class LNDistribution implements Serializable {
        private double[] disTop100;
        private String[] lnTop100;
        private String[] otherln;

        public double[] getDisTop100() {
            return disTop100;
        }

        public void setDisTop100(double[] disTop100) {
            this.disTop100 = disTop100;
        }

        public String[] getLnTop100() {
            return lnTop100;
        }

        public void setLnTop100(String[] lnTop100) {
            this.lnTop100 = lnTop100;
        }

        public String[] getOtherln() {
            return otherln;
        }

        public void setOtherln(String[] otherln) {
            this.otherln = otherln;
        }
    }
}
