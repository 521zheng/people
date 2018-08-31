package org.leesia.resource.controller;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.service.PersonService;
import org.leesia.resource.service.PersonCreateService;
import org.leesia.resource.util.SpringUtil;
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
    private PersonCreateService personCreateService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
        String name = request.getParameter("name");
        String nation = request.getParameter("nation");
        String registerProvince = request.getParameter("registerProvince");
        String registerCity = request.getParameter("registerCity");
        String liveProvince = request.getParameter("liveProvince");
        String liveCity = request.getParameter("liveCity");
        Integer sex = null;
        String s = request.getParameter("sex");
        if (StringUtils.isNotBlank(s)) {
            try {
                sex = Integer.valueOf(s);
            } catch (Exception e) {
                logger.error("性别转换异常：" + e);
            }
        }

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

    @RequestMapping(value = "create", method = RequestMethod.GET)
    @ResponseBody
    public Object create(HttpServletRequest request, @RequestParam int count) {
        logger.info("生成个人信息：{}", count);

        personCreateService.create(count, 1000);
        return true;
    }
}
