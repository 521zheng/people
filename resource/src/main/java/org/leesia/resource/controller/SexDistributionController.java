package org.leesia.resource.controller;

import org.leesia.dataio.service.ProvinceDistributionService;
import org.leesia.dataio.service.SexDistributionService;
import org.leesia.entity.ProvinceDistribution;
import org.leesia.entity.SexDistribution;
import org.leesia.enums.Sex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 23:13
 * @Description:
 */
@RestController
@RequestMapping(value = "sex/distribution")
public class SexDistributionController {

    private static final Logger logger = LoggerFactory.getLogger(SexDistributionController.class);

    @Autowired
    private SexDistributionService sexDistributionService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
        logger.info("查询全部性别分布");
        return sexDistributionService.get(new HashMap<>());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpServletRequest request, SexDistribution distribution) {
        logger.info("增加性别分布");
        return sexDistributionService.insert(distribution);
    }

    @RequestMapping(value = "getByProvince", method = RequestMethod.GET)
    @ResponseBody
    public Object getByProvince(HttpServletRequest request, @RequestParam int sex) {
        logger.info("查询性别分布：{}", sex);
        return sexDistributionService.getBySex(sex);
    }
}
