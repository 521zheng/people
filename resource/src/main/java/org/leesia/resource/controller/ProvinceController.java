package org.leesia.resource.controller;

import org.leesia.dataio.service.ProvinceService;
import org.leesia.entity.Province;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 13:22
 * @Description:
 */
@RestController
@RequestMapping(value = "province")
public class ProvinceController {

    private static final Logger logger = LoggerFactory.getLogger(ProvinceController.class);

    @Autowired
    private ProvinceService provinceService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
        logger.info("查询全部省份");
        return provinceService.get(new HashMap<>());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpServletRequest request, Province province) {
        logger.info("增加省份");
        return provinceService.insert(province);
    }

    @RequestMapping(value = "getByName", method = RequestMethod.GET)
    @ResponseBody
    public Object getByName(HttpServletRequest request, @RequestParam String provinceName) {
        logger.info("查询省份：{}", provinceName);
        return provinceService.getByName(provinceName);
    }
}
