package org.leesia.resource.controller;

import org.leesia.dataio.service.LastNameDistributionService;
import org.leesia.entity.LastNameDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 23:09
 * @Description:
 */
@RestController
@RequestMapping(value = "lastName/distribution")
public class LastNameDistributionController {

    private static final Logger logger = LoggerFactory.getLogger(LastNameDistributionController.class);

    @Autowired
    private LastNameDistributionService lastNameDistributionService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
        logger.info("查询全部姓氏人口分布");
        return lastNameDistributionService.get(new HashMap<>());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpServletRequest request, LastNameDistribution distribution) {
        logger.info("增加姓氏人口分布");
        return lastNameDistributionService.insert(distribution);
    }

    @RequestMapping(value = "getByLastName", method = RequestMethod.GET)
    @ResponseBody
    public Object getByLastName(HttpServletRequest request, @RequestParam String lastName) {
        logger.info("查询姓氏人口分布：{}", lastName);
        return lastNameDistributionService.getByLastName(lastName);
    }
}
