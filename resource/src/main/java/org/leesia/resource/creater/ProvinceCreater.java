package org.leesia.resource.creater;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.service.CityService;
import org.leesia.dataio.service.ProvinceDistributionService;
import org.leesia.entity.NationDistribution;
import org.leesia.entity.ProvinceDistribution;
import org.leesia.resource.config.RedisConfig;
import org.leesia.resource.redis.RedisKeyPrefix;
import org.leesia.resource.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

/**
 * @Auther: leesia
 * @Date: 2018/8/16 16:26
 * @Description:
 */
@Service
public class ProvinceCreater {

    private static final Logger logger = LoggerFactory.getLogger(NationCreater.class);

    @Autowired
    private ProvinceDistributionService provinceDistributionService;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private RedisService redisService;

    public String creater() {
        PDistribution pDistribution = distribution();
        double random = Math.random();
        double[] distribution = pDistribution.getDistribution();
        int index = 0;
        for (; index < distribution.length; index++) {
            if (random < distribution[index]) {
                break;
            }
        }
        String[] provinces = pDistribution.getProvinces();
        if (index < distribution.length) {
            return provinces[index];
        }
        return provinces[provinces.length - 1];
    }

    private PDistribution distribution() {
        PDistribution pDistribution = (PDistribution) redisService.getObject(RedisKeyPrefix.ProvinceDistributionPrefix.getPrefix());
        if (pDistribution != null) {
            return pDistribution;
        }
        List<ProvinceDistribution> distributions = provinceDistributionService.get(new HashMap<>());
        double[] distribution = new double[distributions.size()];
        String[] provinces = new String[distributions.size()];
        Map<String, Map<String, Double>> nations = new HashMap<>();
        Map<String, List<String>> lastNames = new HashMap<>();
        double dis = 0;
        for (int i = 0; i < distributions.size(); i++) {
            ProvinceDistribution pd = distributions.get(i);
            Double d = pd.getDistribution();
            if (d != null) {
                dis += pd.getDistribution();
                distribution[i] = dis;
                provinces[i] = pd.getProvinceName();
            }

            String nation = pd.getNationDistribution();
            if (StringUtils.isNotBlank(nation)) {
                Map<String, Double> nationMap = JSONObject.parseObject(nation, Map.class);
                nations.put(pd.getProvinceName(), nationMap);
            }

            String lnd = pd.getLastNameDistribution();
            if (StringUtils.isNotBlank(lnd)) {
                String[] lns = lnd.split(",");
                lastNames.put(pd.getProvinceName(), new ArrayList<>(Arrays.asList(lns)));
            }
        }

        pDistribution = new PDistribution();
        pDistribution.setDistribution(distribution);
        pDistribution.setProvinces(provinces);
        pDistribution.setNations(nations);
        pDistribution.setLastNames(lastNames);
        redisService.setObject(RedisKeyPrefix.ProvinceDistributionPrefix.getPrefix(), pDistribution);

        return pDistribution;
    }

    static class PDistribution implements Serializable {
        private double[] distribution;
        private String[] provinces;
        private Map<String, Map<String, Double>> nations;
        private Map<String, List<String>> lastNames;

        public double[] getDistribution() {
            return distribution;
        }

        public void setDistribution(double[] distribution) {
            this.distribution = distribution;
        }

        public String[] getProvinces() {
            return provinces;
        }

        public void setProvinces(String[] provinces) {
            this.provinces = provinces;
        }

        public Map<String, Map<String, Double>> getNations() {
            return nations;
        }

        public void setNations(Map<String, Map<String, Double>> nations) {
            this.nations = nations;
        }

        public Map<String, List<String>> getLastNames() {
            return lastNames;
        }

        public void setLastNames(Map<String, List<String>> lastNames) {
            this.lastNames = lastNames;
        }
    }
}
