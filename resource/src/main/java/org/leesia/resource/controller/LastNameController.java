package org.leesia.resource.controller;

import org.leesia.dataio.service.LastNameService;
import org.leesia.entity.LastName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Auther: leesia
 * @Date: 2018/8/9 09:39
 * @Description:
 */
@RestController
@RequestMapping(value = "lastName")
public class LastNameController {

    private static final Logger logger = LoggerFactory.getLogger(LastNameController.class);

    @Autowired
    private LastNameService lastNameService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
        logger.info("查询全部姓氏");
        return lastNameService.get(new HashMap<>());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpServletRequest request, LastName lastName) {
        logger.info("增加姓氏");
        return lastNameService.insert(lastName);
    }

    @RequestMapping(value = "getByName", method = RequestMethod.GET)
    @ResponseBody
    public Object getByName(HttpServletRequest request, @RequestParam String lastName) {
        logger.info("查询姓氏：{}", lastName);
        return lastNameService.getByName(lastName);
    }
}
