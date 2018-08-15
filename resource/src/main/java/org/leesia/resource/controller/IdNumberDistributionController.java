package org.leesia.resource.controller;

import org.leesia.dataio.service.IdNumberDistributionService;
import org.leesia.entity.IdNumberDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 22:55
 * @Description:
 */
@RestController
@RequestMapping(value = "idNumber/distribution")
public class IdNumberDistributionController {

    private static final Logger logger = LoggerFactory.getLogger(IdNumberDistributionController.class);

    @Autowired
    private IdNumberDistributionService idNumberDistributionService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
        logger.info("查询全部身份证号码前缀分布");
        return idNumberDistributionService.get(new HashMap<>());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpServletRequest request, IdNumberDistribution distribution) {
        logger.info("增加身份证号码前缀分布");
        return idNumberDistributionService.insert(distribution);
    }

    @RequestMapping(value = "getByProvince", method = RequestMethod.GET)
    @ResponseBody
    public Object getByAge(HttpServletRequest request, @RequestParam String provinceName) {
        logger.info("查询身份证号码前缀分布：{}", provinceName);
        return idNumberDistributionService.getByProvince(provinceName);
    }
}
