package org.leesia.resource.controller;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.service.PersonService;
import org.leesia.entity.City;
import org.leesia.entity.Person;
import org.leesia.entity.Province;
import org.leesia.resource.creater.LastNameCreater;
import org.leesia.resource.creater.NationCreater;
import org.leesia.resource.creater.SexCreater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Auther: leesia
 * @Date: 2018/8/16 0:23
 * @Description:
 */
@RestController
@RequestMapping(value = "person")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private LastNameCreater lastNameCreater;

    @Autowired
    private SexCreater sexCreater;

    @Autowired
    private NationCreater nationCreater;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public Object get(HttpServletRequest request, @RequestParam String name, @RequestParam String nation, @RequestParam Integer sex,
                      @RequestParam String registerProvince, @RequestParam String registerCity, @RequestParam String liveProvince, @RequestParam String liveCity) {
        logger.info("查询个人信息：name={}，nation={}，sex={}，registerProvince={}，registerCity={}，liveProvince={}，liveCity={}", name, nation, sex, registerProvince, registerCity, liveProvince, liveCity);
        if (StringUtils.isBlank(name) && StringUtils.isBlank(nation) && sex == null
                && StringUtils.isBlank(registerProvince) && StringUtils.isBlank(registerCity)
                && StringUtils.isBlank(liveProvince) && StringUtils.isBlank(liveCity)) {
            logger.error("查询条件为空");
            return null;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("nation", nation);
        params.put("sex", sex);
        params.put("registerProvince", registerProvince);
        params.put("registerCity", registerCity);
        params.put("liveProvince", liveProvince);
        params.put("liveCity", liveCity);

        return personService.get(params);
    }

    @RequestMapping(value = "creater", method = RequestMethod.GET)
    @ResponseBody
    public Object creater(HttpServletRequest request) {
        logger.info("生成个人信息");

        String lastName = lastNameCreater.creater();
        int sex = sexCreater.creater();
        String nation = nationCreater.creater();

        City city = null;
        Person person = new Person();
        person.setId("");
        person.setName(lastName);
        person.setSex(sex);
        person.setBirthday("");
        person.setNation(nation);
        person.setRegisterProvince("");
        person.setRegisterCity("");
        person.setLiveProvince("");
        person.setLiveCity("");
        person.setCreateDatetime(new Date());
        person.setUpdateDatetime(new Date());

        return person;
    }

}
