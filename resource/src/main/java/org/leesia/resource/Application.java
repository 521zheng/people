package org.leesia.resource;

import org.leesia.resource.res.*;
import org.leesia.resource.service.PersonCreateService;
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

//        resource();
    }

    public static void resource() {
        try {
            provinceResource();
            cityResource();
            ageDistributionResource();
            sexDistributionResource();
            idNumberDistributionResource();
            lastNameResource();
            lastNameDistributionResource();
            nationResource();
            nationDistributionResource();
            provinceDistributionResource();
            hanziResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void provinceResource() {
        ProvinceResource provinceResource = (ProvinceResource) SpringUtil.getBean("provinceResource");
        provinceResource.insertAllProvince();
    }

    public static void cityResource() throws Exception {
        CityResource cityResource = (CityResource) SpringUtil.getBean("cityResource");
        cityResource.insertAllCity();
    }

    public static void ageDistributionResource() {
        AgeDistributionResource ageDistributionResource = (AgeDistributionResource) SpringUtil.getBean("ageDistributionResource");
        ageDistributionResource.insertAllAgeDistribution();
    }

    public static void sexDistributionResource() {
        SexDistributionResource sexDistributionResource = (SexDistributionResource) SpringUtil.getBean("sexDistributionResource");
        sexDistributionResource.insertAllSexDistribution();
    }

    public static void idNumberDistributionResource() throws Exception {
        IdNumberDistributionResource idNumberDistributionResource = (IdNumberDistributionResource) SpringUtil.getBean("idNumberDistributionResource");
        idNumberDistributionResource.insertAllIdNumberDistribution();
    }

    public static void lastNameResource() {
        LastNameResource lastNameResource = (LastNameResource) SpringUtil.getBean("lastNameResource");
        lastNameResource.insertAllLastName();
    }

    public static void lastNameDistributionResource() throws Exception {
        LastNameDistributionResource lastNameDistributionResource = (LastNameDistributionResource) SpringUtil.getBean("lastNameDistributionResource");
        lastNameDistributionResource.insertAllLastNameDistribution();
    }

    public static void nationResource() {
        NationResource nationResource = (NationResource) SpringUtil.getBean("nationResource");
        nationResource.insertAllNation();
    }

    public static void nationDistributionResource() {
        NationDistributionResource nationDistributionResource = (NationDistributionResource) SpringUtil.getBean("nationDistributionResource");
        nationDistributionResource.insertAllNationDistribution();
    }

    public static void provinceDistributionResource() throws Exception {
        ProvinceDistributionResource provinceDistributionResource = (ProvinceDistributionResource) SpringUtil.getBean("provinceDistributionResource");
        provinceDistributionResource.insertAllProvinceDistribution();
    }

    public static void hanziResource() throws Exception {
        HanziResource hanziResource = (HanziResource) SpringUtil.getBean("hanziResource");
        hanziResource.insertAllHanzi();
    }
}
