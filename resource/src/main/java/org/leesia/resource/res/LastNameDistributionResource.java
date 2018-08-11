package org.leesia.resource.res;

import org.leesia.dataio.service.LastNameDistributionService;
import org.leesia.dataio.service.LastNameService;
import org.leesia.entity.LastName;
import org.leesia.entity.LastNameDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/10 19:58
 * @Description:
 */
@Service
public class LastNameDistributionResource {

    private static final Logger logger = LoggerFactory.getLogger(LastNameDistributionResource.class);

    private Map<String, Double> LAST_NAME_DISTRIBUTION = new HashMap<>();

    @Autowired
    private LastNameDistributionService lastNameDistributionService;

    @Autowired
    private LastNameService lastNameService;

    public LastNameDistributionResource() {
        LAST_NAME_DISTRIBUTION.put("李", 0.0794);
        LAST_NAME_DISTRIBUTION.put("王", 0.0741);
        LAST_NAME_DISTRIBUTION.put("张", 0.0707);
        LAST_NAME_DISTRIBUTION.put("刘", 0.0538);
        LAST_NAME_DISTRIBUTION.put("陈", 0.0453);
        LAST_NAME_DISTRIBUTION.put("杨", 0.0308);
        LAST_NAME_DISTRIBUTION.put("赵", 0.0229);
        LAST_NAME_DISTRIBUTION.put("黄", 0.0223);
        LAST_NAME_DISTRIBUTION.put("周", 0.0212);
        LAST_NAME_DISTRIBUTION.put("吴", 0.0205);
        LAST_NAME_DISTRIBUTION.put("徐", 0.0167);
        LAST_NAME_DISTRIBUTION.put("孙", 0.0154);
        LAST_NAME_DISTRIBUTION.put("胡", 0.0131);
        LAST_NAME_DISTRIBUTION.put("朱", 0.0126);
        LAST_NAME_DISTRIBUTION.put("高", 0.0121);
        LAST_NAME_DISTRIBUTION.put("林", 0.0118);
        LAST_NAME_DISTRIBUTION.put("何", 0.0117);
        LAST_NAME_DISTRIBUTION.put("郭", 0.0115);
        LAST_NAME_DISTRIBUTION.put("马", 0.0105);
        LAST_NAME_DISTRIBUTION.put("罗", 0.0086);
        LAST_NAME_DISTRIBUTION.put("梁", 0.0084);
        LAST_NAME_DISTRIBUTION.put("宋", 0.0081);
        LAST_NAME_DISTRIBUTION.put("郑", 0.0078);
        LAST_NAME_DISTRIBUTION.put("谢", 0.0072);
        LAST_NAME_DISTRIBUTION.put("韩", 0.0068);
        LAST_NAME_DISTRIBUTION.put("唐", 0.0065);
        LAST_NAME_DISTRIBUTION.put("冯", 0.0064);
        LAST_NAME_DISTRIBUTION.put("于", 0.0062);
        LAST_NAME_DISTRIBUTION.put("董", 0.0061);
        LAST_NAME_DISTRIBUTION.put("萧", 0.0059);
        LAST_NAME_DISTRIBUTION.put("程", 0.0057);
        LAST_NAME_DISTRIBUTION.put("曹", 0.0057);
        LAST_NAME_DISTRIBUTION.put("袁", 0.0054);
        LAST_NAME_DISTRIBUTION.put("邓", 0.0054);
        LAST_NAME_DISTRIBUTION.put("许", 0.0054);
        LAST_NAME_DISTRIBUTION.put("傅", 0.0051);
        LAST_NAME_DISTRIBUTION.put("沈", 0.005);
        LAST_NAME_DISTRIBUTION.put("曾", 0.005);
        LAST_NAME_DISTRIBUTION.put("彭", 0.0049);
        LAST_NAME_DISTRIBUTION.put("吕", 0.0047);
        LAST_NAME_DISTRIBUTION.put("苏", 0.0047);
        LAST_NAME_DISTRIBUTION.put("卢", 0.0047);
        LAST_NAME_DISTRIBUTION.put("蒋", 0.0047);
        LAST_NAME_DISTRIBUTION.put("蔡", 0.0046);
        LAST_NAME_DISTRIBUTION.put("魏", 0.0045);
        LAST_NAME_DISTRIBUTION.put("贾", 0.0042);
        LAST_NAME_DISTRIBUTION.put("丁", 0.0042);
        LAST_NAME_DISTRIBUTION.put("薛", 0.0042);
        LAST_NAME_DISTRIBUTION.put("叶", 0.0042);
        LAST_NAME_DISTRIBUTION.put("阎", 0.0041);
        LAST_NAME_DISTRIBUTION.put("余", 0.0041);
        LAST_NAME_DISTRIBUTION.put("潘", 0.0041);
        LAST_NAME_DISTRIBUTION.put("杜", 0.004);
        LAST_NAME_DISTRIBUTION.put("戴", 0.0039);
        LAST_NAME_DISTRIBUTION.put("夏", 0.0039);
        LAST_NAME_DISTRIBUTION.put("钟", 0.0038);
        LAST_NAME_DISTRIBUTION.put("汪", 0.0037);
        LAST_NAME_DISTRIBUTION.put("田", 0.0037);
        LAST_NAME_DISTRIBUTION.put("任", 0.0037);
        LAST_NAME_DISTRIBUTION.put("姜", 0.0036);
        LAST_NAME_DISTRIBUTION.put("范", 0.0036);
        LAST_NAME_DISTRIBUTION.put("方", 0.0036);
        LAST_NAME_DISTRIBUTION.put("石", 0.0035);
        LAST_NAME_DISTRIBUTION.put("姚", 0.0035);
        LAST_NAME_DISTRIBUTION.put("谭", 0.0034);
        LAST_NAME_DISTRIBUTION.put("廖", 0.0034);
        LAST_NAME_DISTRIBUTION.put("邹", 0.0033);
        LAST_NAME_DISTRIBUTION.put("熊", 0.0032);
        LAST_NAME_DISTRIBUTION.put("金", 0.0032);
        LAST_NAME_DISTRIBUTION.put("陆", 0.0031);
        LAST_NAME_DISTRIBUTION.put("郝", 0.003);
        LAST_NAME_DISTRIBUTION.put("孔", 0.0029);
        LAST_NAME_DISTRIBUTION.put("白", 0.0029);
        LAST_NAME_DISTRIBUTION.put("崔", 0.0028);
        LAST_NAME_DISTRIBUTION.put("康", 0.0028);
        LAST_NAME_DISTRIBUTION.put("毛", 0.0027);
        LAST_NAME_DISTRIBUTION.put("邱", 0.0027);
        LAST_NAME_DISTRIBUTION.put("秦", 0.0026);
        LAST_NAME_DISTRIBUTION.put("江", 0.0026);
        LAST_NAME_DISTRIBUTION.put("史", 0.0025);
        LAST_NAME_DISTRIBUTION.put("顾", 0.0025);
        LAST_NAME_DISTRIBUTION.put("侯", 0.0025);
        LAST_NAME_DISTRIBUTION.put("邵", 0.0024);
        LAST_NAME_DISTRIBUTION.put("孟", 0.0024);
        LAST_NAME_DISTRIBUTION.put("龙", 0.0024);
        LAST_NAME_DISTRIBUTION.put("万", 0.0024);
        LAST_NAME_DISTRIBUTION.put("段", 0.0023);
        LAST_NAME_DISTRIBUTION.put("雷", 0.0023);
        LAST_NAME_DISTRIBUTION.put("钱", 0.0022);
        LAST_NAME_DISTRIBUTION.put("汤", 0.0019);
        LAST_NAME_DISTRIBUTION.put("尹", 0.0019);
        LAST_NAME_DISTRIBUTION.put("易", 0.0019);
        LAST_NAME_DISTRIBUTION.put("黎", 0.0019);
        LAST_NAME_DISTRIBUTION.put("常", 0.0018);
        LAST_NAME_DISTRIBUTION.put("武", 0.0018);
        LAST_NAME_DISTRIBUTION.put("乔", 0.0018);
        LAST_NAME_DISTRIBUTION.put("贺", 0.0018);
        LAST_NAME_DISTRIBUTION.put("赖", 0.0018);
        LAST_NAME_DISTRIBUTION.put("龚", 0.0017);
        LAST_NAME_DISTRIBUTION.put("文", 0.0017);
    }

    private List<LastNameDistribution> createAllLastNameDistribution() throws Exception {
        List<LastNameDistribution> distributions = new ArrayList<>();
        for (Map.Entry<String, Double> entry : LAST_NAME_DISTRIBUTION.entrySet()) {
            LastNameDistribution distribution = new LastNameDistribution();
            LastName lastName = lastNameService.getByName(entry.getKey());
            if (lastName != null) {
                distribution.setLastName(lastName.getLastName());
                distribution.setDistribution(entry.getValue());
                distributions.add(distribution);
            } else {
                logger.error("没有该姓氏：{}", entry.getKey());
                throw new Exception("没有该姓氏：" +  entry.getKey());
            }
        }
        return distributions;
    }

    public void insertAllLastNameDistribution() throws Exception {
        lastNameDistributionService.batchInsert(createAllLastNameDistribution());
    }
}
