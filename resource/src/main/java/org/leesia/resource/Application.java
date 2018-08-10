package org.leesia.resource;

import org.leesia.resource.res.HanziResource;
import org.leesia.resource.res.NationResource;
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

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        SpringUtil.setApplicationContext(ctx);

//        HanziResource hanziResource = (HanziResource) SpringUtil.getBean("hanziResource");
//        hanziResource.insertAllHanzi();
    }
}
