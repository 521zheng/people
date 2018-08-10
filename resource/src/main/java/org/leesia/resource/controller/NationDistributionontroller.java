package org.leesia.resource.controller;

import org.leesia.dataio.service.NationDistributionService;
import org.leesia.entity.NationDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Auther: leesia
 * @Date: 2018/8/10 18:46
 * @Description:
 */
@RestController
@RequestMapping(value = "nation/distribution")
public class NationDistributionontroller {

    private static final Logger logger = LoggerFactory.getLogger(NationDistributionontroller.class);

    @Autowired
    private NationDistributionService nationDistributionService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
        logger.info("查询全部民族人口分布");
        return nationDistributionService.get(new HashMap<>());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpServletRequest request, NationDistribution distribution) {
        logger.info("增加民族人口分布");
        return nationDistributionService.insert(distribution);
    }

    @RequestMapping(value = "getByNation", method = RequestMethod.GET)
    @ResponseBody
    public Object getByNation(HttpServletRequest request, @RequestParam String nationName) {
        logger.info("查询民族人口分布：{}", nationName);
        return nationDistributionService.getByNation(nationName);
    }
}
