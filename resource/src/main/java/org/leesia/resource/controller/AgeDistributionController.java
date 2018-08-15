package org.leesia.resource.controller;

import org.leesia.dataio.service.AgeDistributionService;
import org.leesia.entity.AgeDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 22:57
 * @Description:
 */
@RestController
@RequestMapping(value = "age/distribution")
public class AgeDistributionController {

    private static final Logger logger = LoggerFactory.getLogger(AgeDistributionController.class);

    @Autowired
    private AgeDistributionService ageDistributionService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
        logger.info("查询全部人口年龄分布");
        return ageDistributionService.get(new HashMap<>());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpServletRequest request, AgeDistribution distribution) {
        logger.info("增加人口年龄分布");
        return ageDistributionService.insert(distribution);
    }

    @RequestMapping(value = "getByAge", method = RequestMethod.GET)
    @ResponseBody
    public Object getByAge(HttpServletRequest request, @RequestParam int age) {
        logger.info("查询人口年龄分布：{}", age);
        return ageDistributionService.getByAge(age);
    }
}
