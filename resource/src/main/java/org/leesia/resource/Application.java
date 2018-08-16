package org.leesia.resource;

import org.leesia.resource.res.*;
import org.leesia.resource.util.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

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

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Application.class, args);
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        SpringUtil.setApplicationContext(ctx);

//        ProvinceResource provinceResource = (ProvinceResource) SpringUtil.getBean("provinceResource");
//        provinceResource.insertAllProvince();

//        CityResource cityResource = (CityResource) SpringUtil.getBean("cityResource");
//        cityResource.insertAllCity();

//        AgeDistributionResource ageDistributionResource = (AgeDistributionResource) SpringUtil.getBean("ageDistributionResource");
//        ageDistributionResource.insertAllAgeDistribution();

//        SexDistributionResource sexDistributionResource = (SexDistributionResource) SpringUtil.getBean("sexDistributionResource");
//        sexDistributionResource.insertAllSexDistribution();

//        IdNumberDistributionResource idNumberDistributionResource = (IdNumberDistributionResource) SpringUtil.getBean("idNumberDistributionResource");
//        idNumberDistributionResource.insertAllIdNumberDistribution();

//        LastNameResource lastNameResource = (LastNameResource) SpringUtil.getBean("lastNameResource");
//        lastNameResource.insertAllLastName();

//        LastNameDistributionResource lastNameDistributionResource = (LastNameDistributionResource) SpringUtil.getBean("lastNameDistributionResource");
//        lastNameDistributionResource.insertAllLastNameDistribution();

//        NationResource nationResource = (NationResource) SpringUtil.getBean("nationResource");
//        nationResource.insertAllNation();

//        NationDistributionResource nationDistributionResource = (NationDistributionResource) SpringUtil.getBean("nationDistributionResource");
//        nationDistributionResource.insertAllNationDistribution();

//        ProvinceDistributionResource provinceDistributionResource = (ProvinceDistributionResource) SpringUtil.getBean("provinceDistributionResource");
//        provinceDistributionResource.insertAllProvinceDistribution();

//        HanziResource hanziResource = (HanziResource) SpringUtil.getBean("hanziResource");
//        hanziResource.insertAllHanzi();
    }
}
