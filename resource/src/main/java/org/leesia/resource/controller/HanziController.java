package org.leesia.resource.controller;

import org.leesia.dataio.service.HanziService;
import org.leesia.entity.Hanzi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Auther: leesia
 * @Date: 2018/8/10 13:31
 * @Description:
 */
@RestController
@RequestMapping(value = "hanzi")
public class HanziController {

    private static final Logger logger = LoggerFactory.getLogger(HanziController.class);

    @Autowired
    private HanziService hanziService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(HttpServletRequest request) {
        logger.info("查询全部常用汉字");
        return hanziService.get(new HashMap<>());
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpServletRequest request, Hanzi hanzi) {
        logger.info("增加常用汉字");
        return hanziService.insert(hanzi);
    }

    @RequestMapping(value = "getByName", method = RequestMethod.GET)
    @ResponseBody
    public Object getByName(HttpServletRequest request, @RequestParam String hanziName) {
        logger.info("查询常用汉字：{}", hanziName);
        return hanziService.getByName(hanziName);
    }
}
