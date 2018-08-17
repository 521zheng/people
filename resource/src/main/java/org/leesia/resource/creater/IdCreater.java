package org.leesia.resource.creater;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.service.IdNumberDistributionService;
import org.leesia.entity.IdNumberDistribution;
import org.leesia.resource.config.RedisConfig;
import org.leesia.resource.redis.RedisKeyPrefix;
import org.leesia.resource.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: leesia
 * @Date: 2018/8/17 12:54
 * @Description:
 */
@Service
public class IdCreater {

    public static final String DEFAULT_PREFIX = "000000";

    @Autowired
    private IdNumberDistributionService idNumberDistributionService;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private RedisService redisService;

    public String creater(String provinceName, String birthday, int sex) {
        int[] sexes = new int[]{0, 2, 4, 6, 8};
        String prefix = getIdNumberPrefix(provinceName);
        String date = birthday.replaceAll("-", "");
        String police = "" + (10 + new Random().nextInt(90));
        int ss = sexes[new Random().nextInt(5)];
        String s = "" + (sex == 0 ? ss + 1 : ss);
        String suffix = "" + new Random().nextInt(10);

        return prefix + date + police + s + suffix;
    }

    private String getIdNumberPrefix(String provinceName) {
        Map<String, List<String>> distributionMap = distribution();
        List<String> idNumbers = distributionMap.get(provinceName);
        if (idNumbers.isEmpty()) {
            return IdCreater.DEFAULT_PREFIX;
        }
        int random = new Random().nextInt(idNumbers.size());
        return idNumbers.get(random);
    }

    private Map<String, List<String>> distribution() {
        Map<String, List<String>> distributionMap = (Map<String, List<String>>) redisService.getObject(RedisKeyPrefix.IdNumberDistributionPrefix.getPrefix());
        if (distributionMap != null) {
            return distributionMap;
        }

        distributionMap = new HashMap<>();
        List<IdNumberDistribution> distributions = idNumberDistributionService.get(new HashMap<>());
        for (IdNumberDistribution distribution : distributions) {
            String idNumber = distribution.getIdNumber();
            if (StringUtils.isBlank(idNumber)) {
                distributionMap.put(distribution.getProvinceName(), new ArrayList<>());
            } else {
                String[] idNumbers = idNumber.split(",");
                distributionMap.put(distribution.getProvinceName(), Arrays.asList(idNumbers));
            }
        }

        redisService.setObject(RedisKeyPrefix.IdNumberDistributionPrefix.getPrefix(), distributionMap);

        return distributionMap;
    }
}
