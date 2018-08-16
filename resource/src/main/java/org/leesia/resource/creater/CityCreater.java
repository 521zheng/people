package org.leesia.resource.creater;

import org.leesia.dataio.service.CityService;
import org.leesia.dataio.service.NationDistributionService;
import org.leesia.dataio.service.ProvinceDistributionService;
import org.leesia.resource.config.RedisConfig;
import org.leesia.resource.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ProvinceDistributionService provinceDistributionService;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private RedisService redisService;
}
