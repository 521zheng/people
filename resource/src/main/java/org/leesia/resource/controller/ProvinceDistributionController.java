package org.leesia.resource.controller;

import org.leesia.dataio.service.ProvinceDistributionService;
import org.leesia.entity.ProvinceDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 23:11
 * @Description:
 */
@RestController
@RequestMapping(value = "province/distribution")
public class ProvinceDistributionController {

    private static final Logger logger = LoggerFactory.getLogger(LastNameDistributionController.class);

    @Autowired
    private ProvinceDistributionService provinceDistributionService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
        logger.info("查询全部省份人口分布");
        return provinceDistributionService.get(new HashMap<>());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpServletRequest request, ProvinceDistribution distribution) {
        logger.info("增加省份人口分布");
        return provinceDistributionService.insert(distribution);
    }

    @RequestMapping(value = "getByProvince", method = RequestMethod.GET)
    @ResponseBody
    public Object getByProvince(HttpServletRequest request, @RequestParam String provinceName) {
        logger.info("查询省份人口分布：{}", provinceName);
        return provinceDistributionService.getByProvince(provinceName);
    }
}
