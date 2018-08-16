package org.leesia.resource.redis;

/**
 * @Auther: leesia
 * @Date: 2018/8/9 09:20
 * @Description:
 */
public enum RedisKeyPrefix {
    ProvincePrefix("PROVINCE", "省份Key前缀"),
    CityPrefix("CITY", "城市Key前缀"),
    LastNamePrefix("LAST_NAME", "姓氏Key前缀"),
    NationPrefix("NATION", "民族Key前缀"),
    NationDistributionPrefix("NATION_DISTRIBUTION", "民族人口分布Key前缀"),
    HanziPrefix("HANZI", "汉字Key前缀"),
    LastNameDistributionPrefix("LAST_NAME_DISTRIBUTION", "姓氏分布Key前缀"),
    SexDistributionPrefix("SEX_DISTRIBUTION", "性别分布Key前缀"),
    ProvinceDistributionPrefix("PROVINCE_DISTRIBUTION", "省份人口分布Key前缀"),
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
