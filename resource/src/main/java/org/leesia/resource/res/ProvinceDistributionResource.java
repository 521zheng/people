package org.leesia.resource.res;

import com.alibaba.fastjson.JSONObject;
import org.leesia.dataio.service.*;
import org.leesia.entity.*;
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
public class ProvinceDistributionResource {

    private static final Logger logger = LoggerFactory.getLogger(ProvinceDistributionResource.class);

    private Map<String, Double> PROVINCE_DISTRIBUTION = new HashMap<>();

    private Map<String, Double> HAN_NATION_DISTRIBUTION = new HashMap<>();

    private Map<String, String> LAST_NAME_DISTRIBUTION = new HashMap<>();

    @Autowired
    private ProvinceDistributionService provinceDistributionService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private LastNameService lastNameService;

    public ProvinceDistributionResource() {
        PROVINCE_DISTRIBUTION.put("广东省", 0.0779);
        PROVINCE_DISTRIBUTION.put("山东省", 0.0715);
        PROVINCE_DISTRIBUTION.put("河南省", 0.0702);
        PROVINCE_DISTRIBUTION.put("四川省", 0.06);
        PROVINCE_DISTRIBUTION.put("江苏省", 0.0587);
        PROVINCE_DISTRIBUTION.put("河北省", 0.0536);
        PROVINCE_DISTRIBUTION.put("湖南省", 0.049);
        PROVINCE_DISTRIBUTION.put("安徽省", 0.0444);
        PROVINCE_DISTRIBUTION.put("湖北省", 0.0427);
        PROVINCE_DISTRIBUTION.put("浙江省", 0.0406);
        PROVINCE_DISTRIBUTION.put("广西壮族自治区", 0.0344);
        PROVINCE_DISTRIBUTION.put("云南省", 0.0343);
        PROVINCE_DISTRIBUTION.put("江西省", 0.0333);
        PROVINCE_DISTRIBUTION.put("辽宁省", 0.0327);
        PROVINCE_DISTRIBUTION.put("黑龙江省", 0.0286);
        PROVINCE_DISTRIBUTION.put("陕西省", 0.0279);
        PROVINCE_DISTRIBUTION.put("福建省", 0.0275);
        PROVINCE_DISTRIBUTION.put("山西省", 0.0267);
        PROVINCE_DISTRIBUTION.put("贵州省", 0.0259);
        PROVINCE_DISTRIBUTION.put("重庆市", 0.0215);
        PROVINCE_DISTRIBUTION.put("吉林省", 0.0205);
        PROVINCE_DISTRIBUTION.put("甘肃省", 0.0191);
        PROVINCE_DISTRIBUTION.put("内蒙古自治区", 0.0184);
        PROVINCE_DISTRIBUTION.put("上海市", 0.0172);
        PROVINCE_DISTRIBUTION.put("新疆维吾尔自治区", 0.0163);
        PROVINCE_DISTRIBUTION.put("北京市", 0.0146);
        PROVINCE_DISTRIBUTION.put("天津市", 0.0097);
        PROVINCE_DISTRIBUTION.put("海南省", 0.0065);
        PROVINCE_DISTRIBUTION.put("宁夏回族自治区", 0.0047);
        PROVINCE_DISTRIBUTION.put("青海省", 0.0042);
        PROVINCE_DISTRIBUTION.put("西藏自治区", 0.0022);

        HAN_NATION_DISTRIBUTION.put("江西省", 0.9973);
        HAN_NATION_DISTRIBUTION.put("山西省", 0.9971);
        HAN_NATION_DISTRIBUTION.put("江苏省", 0.9967);
        HAN_NATION_DISTRIBUTION.put("陕西省", 0.9951);
        HAN_NATION_DISTRIBUTION.put("上海市", 0.994);
        HAN_NATION_DISTRIBUTION.put("安徽省", 0.9937);
        HAN_NATION_DISTRIBUTION.put("山东省", 0.9932);
        HAN_NATION_DISTRIBUTION.put("浙江省", 0.9915);
        HAN_NATION_DISTRIBUTION.put("河南省", 0.9878);
        HAN_NATION_DISTRIBUTION.put("广东省", 0.9858);
        HAN_NATION_DISTRIBUTION.put("福建省", 0.9833);
        HAN_NATION_DISTRIBUTION.put("天津市", 0.9736);
        HAN_NATION_DISTRIBUTION.put("北京市", 0.9574);
        HAN_NATION_DISTRIBUTION.put("河北省", 0.9569);
        HAN_NATION_DISTRIBUTION.put("湖北省", 0.9566);
        HAN_NATION_DISTRIBUTION.put("四川省", 0.9502);
        HAN_NATION_DISTRIBUTION.put("黑龙江省", 0.9498);
        HAN_NATION_DISTRIBUTION.put("重庆市", 0.9358);
        HAN_NATION_DISTRIBUTION.put("甘肃省", 0.9131);
        HAN_NATION_DISTRIBUTION.put("吉林省", 0.9097);
        HAN_NATION_DISTRIBUTION.put("湖南省", 0.8979);
        HAN_NATION_DISTRIBUTION.put("辽宁省", 0.8398);
        HAN_NATION_DISTRIBUTION.put("海南省", 0.8271);
        HAN_NATION_DISTRIBUTION.put("内蒙古自治区", 0.7924);
        HAN_NATION_DISTRIBUTION.put("云南省", 0.6659);
        HAN_NATION_DISTRIBUTION.put("宁夏回族自治区", 0.6547);
        HAN_NATION_DISTRIBUTION.put("贵州省", 0.6215);
        HAN_NATION_DISTRIBUTION.put("广西壮族自治区", 0.6166);
        HAN_NATION_DISTRIBUTION.put("青海省", 0.5449);
        HAN_NATION_DISTRIBUTION.put("新疆维吾尔自治区", 0.4061);
        HAN_NATION_DISTRIBUTION.put("西藏自治区", 0.0593);

        LAST_NAME_DISTRIBUTION.put("广东省", "陈;李;黄;张;梁;林;刘;吴;罗;杨");
        LAST_NAME_DISTRIBUTION.put("海南省", "陈;王;李;吴;符;林;黄;张;周;郑");
        LAST_NAME_DISTRIBUTION.put("重庆市", "李;张;陈;刘;王;杨;周;黄;罗;唐");
        LAST_NAME_DISTRIBUTION.put("山东省", "王;张;李;刘;孙;赵;杨;陈;徐;马");
        LAST_NAME_DISTRIBUTION.put("福建省", "陈;林;黄;张;吴;李;王;郑;刘;杨");
        LAST_NAME_DISTRIBUTION.put("浙江省", "陈;王;林;张;李;叶;郑;吴;徐;刘");
        LAST_NAME_DISTRIBUTION.put("江西省", "刘;李;陈;张;黄;王;吴;周;胡;徐");
        LAST_NAME_DISTRIBUTION.put("内蒙古自治区", "王;张;李;刘;赵;杨;郭;孙;高;陈");
        LAST_NAME_DISTRIBUTION.put("湖南省", "李;刘;陈;张;王;周;黄;杨;唐;罗");
        LAST_NAME_DISTRIBUTION.put("河南省", "王;张;李;刘;杨;赵;陈;郭;孙;马");
        LAST_NAME_DISTRIBUTION.put("北京市", "王;张;李;刘;赵;杨;陈;孙;高;马");
        LAST_NAME_DISTRIBUTION.put("江苏省", "王;张;陈;李;徐;周;朱;刘;吴;杨");
        LAST_NAME_DISTRIBUTION.put("山西省", "王;张;李;刘;赵;郭;杨;陈;武;高");
        LAST_NAME_DISTRIBUTION.put("湖北省", "李;刘;张;陈;杨;胡;黄;王;徐;周");
        LAST_NAME_DISTRIBUTION.put("天津市", "王;张;李;刘;杨;赵;陈;孙;高;马");
        LAST_NAME_DISTRIBUTION.put("宁夏回族自治区", "王;张;李;刘;杨;陈;赵;吴;马;孙");
        LAST_NAME_DISTRIBUTION.put("辽宁省", "王;李;张;刘;赵;孙;杨;陈;于;高");
        LAST_NAME_DISTRIBUTION.put("上海市", "张;王;陈;李;朱;徐;周;沈;吴;陆");
        LAST_NAME_DISTRIBUTION.put("河北省", "张;王;李;刘;赵;杨;高;陈;马;郭");
        LAST_NAME_DISTRIBUTION.put("安徽省", "王;张;李;陈;刘;杨;吴;周;徐;孙");
        LAST_NAME_DISTRIBUTION.put("新疆维吾尔自治区", "王;张;李;刘;杨;徐;吴;朱;郭;黄");
        LAST_NAME_DISTRIBUTION.put("黑龙江省", "王;张;李;刘;赵;孙;杨;陈;于;徐");
        LAST_NAME_DISTRIBUTION.put("四川省", "李;张;王;刘;陈;杨;周;黄;罗;吴");
        LAST_NAME_DISTRIBUTION.put("广西壮族自治区", "黄;莫;韦;覃;农;蒙;蓝;赵;罗;梁");
        LAST_NAME_DISTRIBUTION.put("云南省", "李;张;杨;王;陈;刘;赵;马;周;朱");
        LAST_NAME_DISTRIBUTION.put("贵州省", "王;李;陈;张;杨;刘;周;罗;吴;黄");
        LAST_NAME_DISTRIBUTION.put("陕西省", "张;王;李;赵;刘;马;杨;陈;吴;郭");
        LAST_NAME_DISTRIBUTION.put("甘肃省", "王;张;李;刘;杨;马;陈;赵;魏;周");
        LAST_NAME_DISTRIBUTION.put("青海省", "李;张;王;刘;赵;杨;陈;马;郭;吴");
        LAST_NAME_DISTRIBUTION.put("吉林省", "王;李;张;刘;赵;孙;杨;陈;于;高");
        LAST_NAME_DISTRIBUTION.put("台湾省", "陈;林;黄;张;李;王;吴;刘;蔡;杨");

    }

    private List<ProvinceDistribution> createAllProvinceDistribution() throws Exception {
        List<Province> provinces = provinceService.get(new HashMap<>());
        Map<String, Province> provinceMap = new HashMap<>();
        Map<String, ProvinceDistribution> distributionMap = new HashMap<>();
        for (Province province : provinces) {
            provinceMap.put(province.getProvinceName(), province);
            ProvinceDistribution distribution = new ProvinceDistribution();
            distribution.setProvinceName(province.getProvinceName());
            distributionMap.put(province.getProvinceName(), distribution);
        }

        for (Map.Entry<String, Double> entry : PROVINCE_DISTRIBUTION.entrySet()) {
            ProvinceDistribution distribution = distributionMap.get(entry.getKey());
            if (distribution == null) {
                throw new Exception("省份不存在：" + entry.getKey());
            }
            distribution.setDistribution(entry.getValue());
        }

        List<LastName> lastNames = lastNameService.get(new HashMap<>());
        Map<String, LastName> lastNameMap = new HashMap<>();
        for (LastName lastName : lastNames) {
            lastNameMap.put(lastName.getLastName(), lastName);
        }
        for (Map.Entry<String, String> entry : LAST_NAME_DISTRIBUTION.entrySet()) {
            ProvinceDistribution distribution = distributionMap.get(entry.getKey());
            if (distribution == null) {
                throw new Exception("省份不存在：" + entry.getKey());
            }
            String[] names = entry.getValue().split(";");
            for (String name : names) {
                if (!lastNameMap.containsKey(name)) {
                    throw new Exception("姓氏不存在：" + name);
                }
            }
            distribution.setLastNameDistribution(entry.getValue());
        }

        for (Map.Entry<String, Double> entry : HAN_NATION_DISTRIBUTION.entrySet()) {
            ProvinceDistribution distribution = distributionMap.get(entry.getKey());
            if (distribution == null) {
                throw new Exception("省份不存在：" + entry.getKey());
            }
            Map<String, Double> nationMap = new HashMap<>();
            nationMap.put("汉族", entry.getValue());
            JSONObject json = (JSONObject) JSONObject.toJSON(nationMap);

            distribution.setNationDistribution(json.toString());
        }
        return new ArrayList<>(distributionMap.values());
    }

    public void insertAllProvinceDistribution() throws Exception {
        provinceDistributionService.batchInsert(createAllProvinceDistribution());
    }
}
