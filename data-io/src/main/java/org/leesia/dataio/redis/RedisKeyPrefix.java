package org.leesia.dataio.redis;

/**
 * @Auther: leesia
 * @Date: 2018/8/9 09:20
 * @Description:
 */
public enum RedisKeyPrefix {
    ProvincePrefix("PROVINCE_", "省份Key前缀"),
    CityPrefix("CITY_", "城市Key前缀"),
    LastNamePrefix("LAST_NAME_", "姓氏Key前缀"),
    NationPrefix("NATION_", "民族Key前缀"),
    NationDistributionPrefix("NATION_DISTRIBUTION_", "民族人口分布Key前缀"),
    HanziPrefix("HANZI_", "汉字Key前缀"),
    ;

    private RedisKeyPrefix(String prefix, String desc) {
        this.prefix = prefix;
        this.desc = desc;
    }

    private String prefix;

    private String desc;

    public String getPrefix() {
        return prefix;
    }

    public String getDesc() {
        return desc;
    }
}
