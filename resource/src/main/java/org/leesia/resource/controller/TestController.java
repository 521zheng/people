package org.leesia.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: leesia
 * @Date: 2018/7/24 13:48
 * @Description:
 */
@RestController
@RequestMapping(value = "test")
public class TestController {


    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public Object reversal(HttpServletRequest request, @RequestParam String param) {
        return param;
    }
}
