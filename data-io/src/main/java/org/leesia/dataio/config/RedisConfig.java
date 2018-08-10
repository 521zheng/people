package org.leesia.dataio.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: leesia
 * @Date: 2018/8/10 17:43
 * @Description:
 */
@Component
@Configuration
@PropertySource("classpath:redis.properties")
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {

    //redis默认缓存时间，单位为秒
    int DefaultExpire;

    //redis省份缓存时间，单位为秒
    int ProvinceExpire;

    //redis城市缓存时间，单位为秒
    int CityExpire;

    //redis民族缓存时间，单位为秒
    int NationExpire;

    //redis姓氏缓存时间，单位为秒
    int LastNameExpire;

    //redis汉字缓存时间，单位为秒
    int HanziExpire;

    //edis民族人口分布缓存时间，单位为秒
    int NationDistributionExpire;

    public int getDefaultExpire() {
        return DefaultExpire;
    }

    public void setDefaultExpire(int defaultExpire) {
        DefaultExpire = defaultExpire;
    }

    public int getProvinceExpire() {
        return ProvinceExpire;
    }

    public void setProvinceExpire(int provinceExpire) {
        ProvinceExpire = provinceExpire;
    }

    public int getCityExpire() {
        return CityExpire;
    }

    public void setCityExpire(int cityExpire) {
        CityExpire = cityExpire;
    }

    public int getNationExpire() {
        return NationExpire;
    }

    public void setNationExpire(int nationExpire) {
        NationExpire = nationExpire;
    }

    public int getLastNameExpire() {
        return LastNameExpire;
    }

    public void setLastNameExpire(int lastNameExpire) {
        LastNameExpire = lastNameExpire;
    }

    public int getHanziExpire() {
        return HanziExpire;
    }

    public void setHanziExpire(int hanziExpire) {
        HanziExpire = hanziExpire;
    }

    public int getNationDistributionExpire() {
        return NationDistributionExpire;
    }

    public void setNationDistributionExpire(int nationDistributionExpire) {
        NationDistributionExpire = nationDistributionExpire;
    }
}
