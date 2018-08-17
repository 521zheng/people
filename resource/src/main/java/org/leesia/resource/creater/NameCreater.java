package org.leesia.resource.creater;

import org.leesia.dataio.service.HanziService;
import org.leesia.entity.Hanzi;
import org.leesia.resource.config.RedisConfig;
import org.leesia.resource.redis.RedisKeyPrefix;
import org.leesia.resource.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: leesia
 * @Date: 2018/8/17 17:47
 * @Description:
 */
@Service
public class NameCreater {

    @Autowired
    private HanziService hanziService;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private RedisService redisService;

    private HCache hCache() {
        HCache hCache = (HCache) redisService.getObject(RedisKeyPrefix.NameDistributionPrefix.getPrefix());
        if (hCache != null) {
            return hCache;
        }
        List<Hanzi> hanzis = hanziService.get(new HashMap<>());
        return hCache;
    }

    static class HCache implements Serializable {
        private List<String> hanzis;
        private List<String> names;
        private List<String> males;
        private List<String> females;
        private List<String> malePerfects;
        private List<String> femalePerfects;

        public List<String> getHanzis() {
            return hanzis;
        }

        public void setHanzis(List<String> hanzis) {
            this.hanzis = hanzis;
        }

        public List<String> getNames() {
            return names;
        }

        public void setNames(List<String> names) {
            this.names = names;
        }

        public List<String> getMales() {
            return males;
        }

        public void setMales(List<String> males) {
            this.males = males;
        }

        public List<String> getFemales() {
            return females;
        }

        public void setFemales(List<String> females) {
            this.females = females;
        }

        public List<String> getMalePerfects() {
            return malePerfects;
        }

        public void setMalePerfects(List<String> malePerfects) {
            this.malePerfects = malePerfects;
        }

        public List<String> getFemalePerfects() {
            return femalePerfects;
        }

        public void setFemalePerfects(List<String> femalePerfects) {
            this.femalePerfects = femalePerfects;
        }
    }
}
