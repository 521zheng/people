package org.leesia.resource.res;

import org.leesia.dataio.service.NationDistributionService;
import org.leesia.dataio.service.NationService;
import org.leesia.entity.Nation;
import org.leesia.entity.NationDistribution;
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
 * @Date: 2018/8/9 20:56
 * @Description:
 */
@Service
public class NationDistributionResource {

    private static final Logger logger = LoggerFactory.getLogger(NationDistributionResource.class);

    private Map<String, Double> NATION_DISTRIBUTION = new HashMap<>();

    @Autowired
    private NationDistributionService nationDistributionService;

    @Autowired
    private NationService nationService;

    public NationDistributionResource() {
        NATION_DISTRIBUTION.put("汉族", 0.9159);
        NATION_DISTRIBUTION.put("壮族", 0.0127);
        NATION_DISTRIBUTION.put("回族", 0.007943);
        NATION_DISTRIBUTION.put("满族", 0.007794);
        NATION_DISTRIBUTION.put("维吾尔族", 0.007555);
        NATION_DISTRIBUTION.put("苗族", 0.007072);
        NATION_DISTRIBUTION.put("彝族", 0.006538);
        NATION_DISTRIBUTION.put("土家族", 0.006268);
        NATION_DISTRIBUTION.put("藏族", 0.004713);
        NATION_DISTRIBUTION.put("蒙古族", 0.004488);
        NATION_DISTRIBUTION.put("侗族", 0.002161);
        NATION_DISTRIBUTION.put("布依族", 0.002153);
        NATION_DISTRIBUTION.put("瑶族", 0.002098);
        NATION_DISTRIBUTION.put("白族", 0.001451);
        NATION_DISTRIBUTION.put("朝鲜族", 0.001374);
        NATION_DISTRIBUTION.put("哈尼族", 0.001246);
        NATION_DISTRIBUTION.put("黎族", 0.001098);
        NATION_DISTRIBUTION.put("哈萨克族", 0.001097);
        NATION_DISTRIBUTION.put("傣族", 0.000946);
        NATION_DISTRIBUTION.put("畲族", 0.000532);
        NATION_DISTRIBUTION.put("傈僳族", 0.000527);
        NATION_DISTRIBUTION.put("东乡族", 0.000466);
        NATION_DISTRIBUTION.put("仡佬族", 0.000413);
        NATION_DISTRIBUTION.put("拉祜族", 0.000365);
        NATION_DISTRIBUTION.put("佤族", 0.000322);
        NATION_DISTRIBUTION.put("水族", 0.000309);
        NATION_DISTRIBUTION.put("纳西族", 0.000245);
        NATION_DISTRIBUTION.put("羌族", 0.000232);
        NATION_DISTRIBUTION.put("土族", 0.000217);
        NATION_DISTRIBUTION.put("仫佬族", 0.000162);
        NATION_DISTRIBUTION.put("锡伯族", 0.000143);
        NATION_DISTRIBUTION.put("柯尔克孜族", 0.00014);
        NATION_DISTRIBUTION.put("景颇族", 0.000111);
        NATION_DISTRIBUTION.put("达斡尔族", 0.000099);
        NATION_DISTRIBUTION.put("撒拉族", 0.000098);
        NATION_DISTRIBUTION.put("布朗族", 0.00009);
        NATION_DISTRIBUTION.put("毛南族", 0.000076);
        NATION_DISTRIBUTION.put("塔吉克族", 0.000038);
        NATION_DISTRIBUTION.put("普米族", 0.000032);
        NATION_DISTRIBUTION.put("阿昌族", 0.00003);
        NATION_DISTRIBUTION.put("怒族", 0.000028);
        NATION_DISTRIBUTION.put("鄂温克族", 0.000023);
        NATION_DISTRIBUTION.put("京族", 0.000021);
        NATION_DISTRIBUTION.put("基诺族", 0.000017);
        NATION_DISTRIBUTION.put("德昂族", 0.000015);
        NATION_DISTRIBUTION.put("保安族", 0.000015);
        NATION_DISTRIBUTION.put("俄罗斯族", 0.000012);
        NATION_DISTRIBUTION.put("裕固族", 0.000011);
        NATION_DISTRIBUTION.put("乌孜别克族", 0.000008);
        NATION_DISTRIBUTION.put("门巴族", 0.000008);
        NATION_DISTRIBUTION.put("鄂伦春族", 0.000006);
        NATION_DISTRIBUTION.put("独龙族", 0.000005);
        NATION_DISTRIBUTION.put("赫哲族", 0.000004);
        NATION_DISTRIBUTION.put("高山族", 0.000003);
        NATION_DISTRIBUTION.put("珞巴族", 0.000003);
        NATION_DISTRIBUTION.put("塔塔尔族", 0.000003);
    }

    private List<NationDistribution> createAllNationDistribution() {
        List<Nation> nations = nationService.get(new HashMap<>());
        Map<String, Nation> nationMap = new HashMap<>();
        for (Nation nation : nations) {
            nationMap.put(nation.getNationName(), nation);
        }

        List<NationDistribution> distributions = new ArrayList<>();
        for (Map.Entry<String, Double> entry : NATION_DISTRIBUTION.entrySet()) {
            Nation nation = nationMap.get(entry.getKey());
            if (nation != null) {
                NationDistribution distribution = new NationDistribution();
                distribution.setNationName(nation.getNationName());
                distribution.setDistribution(entry.getValue());
                distributions.add(distribution);
            } else {
                logger.error("没有该民族：{}", entry.getKey());
            }
        }
        return distributions;
    }

    public void insertAllNationDistribution() {
        nationDistributionService.batchInsert(createAllNationDistribution());
    }
}
