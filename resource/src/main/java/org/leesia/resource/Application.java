package org.leesia.resource;

import org.leesia.dataio.redis.RedisService;
import org.leesia.dataio.service.CityService;
import org.leesia.dataio.service.ProvinceService;
import org.leesia.dataio.service.impl.CityServiceImpl;
import org.leesia.dataio.service.impl.ProvinceServiceImpl;
import org.leesia.entity.City;
import org.leesia.entity.Province;
import org.leesia.resource.util.CityResource;
import org.leesia.resource.util.ProvinceResource;
import org.leesia.resource.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/7/24 13:46
 * @Description:
 */
@MapperScan("org.leesia.dataio.dao")
@EnableCaching
@ComponentScan(basePackages = {"org.leesia"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        SpringUtil.setApplicationContext(ctx);

//        ProvinceResource provinceResource = (ProvinceResource) SpringUtil.getBean("provinceResource");
//        CityResource cityResource = (CityResource) SpringUtil.getBean("cityResource");
//
//        provinceResource.insertAllCities();
//        cityResource.insertAllCities();
    }

    @Bean
    public ProvinceService provinceService() {
        return new ProvinceServiceImpl();
    }

    @Bean
    public CityService cityService() {
        return new CityServiceImpl();
    }

    @Bean
    public RedisService redisService() {
        return new RedisService();
    }

    @Bean
    public CityResource cityResource() {
        return new CityResource();
    }

    @Bean
    public ProvinceResource provinceResource() {
        return new ProvinceResource();
    }
}
