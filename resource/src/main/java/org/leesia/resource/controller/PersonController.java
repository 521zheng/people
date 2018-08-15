package org.leesia.resource.controller;

import org.leesia.resource.creater.LastNameCreater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    private LastNameCreater lastNameCreater;

    @RequestMapping(value = "creater", method = RequestMethod.GET)
    @ResponseBody
    public Object creater(HttpServletRequest request) {
        logger.info("生成个人信息");

        return lastNameCreater.creater();
    }

}
