package org.leesia.resource.res;

import org.leesia.dataio.service.ProvinceService;
import org.leesia.entity.Province;
import org.leesia.util.PinYinTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 16:43
 * @Description:
 */
@Service
public class ProvinceResource {

    private Map<String, String> PROVINCES = new HashMap<>();

    @Autowired
    private ProvinceService provinceService;

    public ProvinceResource() {
        PROVINCES.put("北京市", "京");
        PROVINCES.put("天津市", "津");
        PROVINCES.put("河北省", "冀");
        PROVINCES.put("山西省", "晋");
        PROVINCES.put("内蒙古自治区", "内蒙古");
        PROVINCES.put("辽宁省", "辽");
        PROVINCES.put("吉林省", "吉");
        PROVINCES.put("黑龙江省", "黑");
        PROVINCES.put("上海市", "沪");
        PROVINCES.put("江苏省", "苏");
        PROVINCES.put("浙江省", "浙");
        PROVINCES.put("安徽省", "皖");
        PROVINCES.put("福建省", "闽");
        PROVINCES.put("江西省", "赣");
        PROVINCES.put("山东省", "鲁");
        PROVINCES.put("河南省", "豫");
        PROVINCES.put("湖北省", "鄂");
        PROVINCES.put("湖南省", "湘");
        PROVINCES.put("广东省", "粤");
        PROVINCES.put("广西壮族自治区", "桂");
        PROVINCES.put("海南省", "琼");
        PROVINCES.put("四川省", "川");
        PROVINCES.put("贵州省", "黔");
        PROVINCES.put("云南省", "滇");
        PROVINCES.put("重庆市", "渝");
        PROVINCES.put("西藏自治区", "藏");
        PROVINCES.put("陕西省", "陕");
        PROVINCES.put("甘肃省", "甘");
        PROVINCES.put("青海省", "青");
        PROVINCES.put("宁夏回族自治区", "宁");
        PROVINCES.put("新疆维吾尔自治区", "新");
        PROVINCES.put("香港特别行政区", "港");
        PROVINCES.put("澳门特别行政区", "澳");
        PROVINCES.put("台湾省", "台");

    }

    private List<Province> createAllProvince() {
        List<Province> provinces = new ArrayList<>();
        for (Map.Entry<String, String> entry : PROVINCES.entrySet()) {
            String pn = entry.getKey();
            String ps = entry.getValue();
            String code = PinYinTool.getFirstLettersUp(ps) + "_" + PinYinTool.getFirstLettersUp(pn);

            Province province = new Province();
            province.setProvinceName(pn);
            province.setProvinceShortName(ps);
            province.setProvinceCode(code);

            provinces.add(province);
        }

        return provinces;
    }

    public void insertAllProvince() {
        provinceService.batchInsert(createAllProvince());
    }
}
