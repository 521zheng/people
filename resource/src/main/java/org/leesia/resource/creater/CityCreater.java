package org.leesia.resource.creater;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.service.CityService;
import org.leesia.entity.City;
import org.leesia.resource.config.RedisConfig;
import org.leesia.resource.redis.RedisKeyPrefix;
import org.leesia.resource.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Auther: leesia
 * @Date: 2018/8/16 16:21
 * @Description:
 */
@Service
public class CityCreater {

    private static final Logger logger = LoggerFactory.getLogger(NationCreater.class);

    @Autowired
    private CityService cityService;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private RedisService redisService;

    public String creater(String provinceName) {
        List<City> cities = getCities(provinceName);
        int random = new Random().nextInt(cities.size());
        return cities.get(random).getCityName();
    }

    private List<City> getCities(String provinceName) {
        if (provinceName == null) {
            provinceName = "";
        }
        List<City> cities = (List<City>) redisService.getObject(RedisKeyPrefix.CityPrefix.getPrefix() + provinceName);
        if (cities != null) {
            return cities;
        }
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(provinceName)) {
            map.put("provinceName", provinceName);
        }
        cities = cityService.get(map);

        redisService.setObject(RedisKeyPrefix.CityPrefix.getPrefix(), provinceName);

        return cities;
    }
}
