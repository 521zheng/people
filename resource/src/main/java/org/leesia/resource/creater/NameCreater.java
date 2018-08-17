package org.leesia.resource.creater;

import org.leesia.dataio.service.HanziService;
import org.leesia.entity.Hanzi;
import org.leesia.resource.config.RedisConfig;
import org.leesia.resource.redis.RedisKeyPrefix;
import org.leesia.resource.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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

    public String creater(String lastName, int sex) {
        HCache hCache = hCache();
        List<String> names = hCache.getNames();
        List<String> perfects = (sex == 0 ? hCache.getMalePerfects() : hCache.getFemalePerfects());
        double random = Math.random();
        String first = (random < 0.4 ? perfects.get(new Random().nextInt(perfects.size())) : names.get(new Random().nextInt(names.size())));
        while (lastName.equals(first)) {
            first = (random < 0.4 ? perfects.get(new Random().nextInt(perfects.size())) : names.get(new Random().nextInt(names.size())));
        }
        String second = "";
        if (random > 0.3) {
            do {
                second = names.get(new Random().nextInt(names.size()));
            } while (lastName.equals(second) || first.equals(second));
        }
        random = Math.random();
        return random > 0.5 ? first + second : second + first;
    }

    private HCache hCache() {
        HCache hCache = (HCache) redisService.getObject(RedisKeyPrefix.NameDistributionPrefix.getPrefix());
        if (hCache != null) {
            return hCache;
        }
        List<Hanzi> hanzis = hanziService.get(new HashMap<>());
        List<String> hs = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> males = new ArrayList<>();
        List<String> females = new ArrayList<>();
        List<String> malePerfects = new ArrayList<>();
        List<String> femalePerfects = new ArrayList<>();
        for (Hanzi hanzi : hanzis) {
            hs.add(hanzi.getHanzi());
            if (hanzi.getIsName() != null && hanzi.getIsName()) {
                names.add(hanzi.getHanzi());
            }
            if (hanzi.getIsMale() != null && hanzi.getIsMale()) {
                males.add(hanzi.getHanzi());
            }
            if (hanzi.getIsFemale() != null && hanzi.getIsFemale()) {
                females.add(hanzi.getHanzi());
            }
            if (hanzi.getMalePerfect() != null && hanzi.getMalePerfect()) {
                malePerfects.add(hanzi.getHanzi());
            }
            if (hanzi.getFemalePerfect() != null && hanzi.getFemalePerfect()) {
                femalePerfects.add(hanzi.getHanzi());
            }
        }
        hCache = new HCache();
        hCache.setHanzis(hs);
        hCache.setNames(names);
        hCache.setMales(males);
        hCache.setFemales(females);
        hCache.setMalePerfects(malePerfects);
        hCache.setFemalePerfects(femalePerfects);
        redisService.setObject(RedisKeyPrefix.NameDistributionPrefix.getPrefix(), hCache);

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
