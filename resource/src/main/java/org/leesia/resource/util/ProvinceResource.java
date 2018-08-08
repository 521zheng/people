package org.leesia.resource.util;

import org.leesia.dataio.service.ProvinceService;
import org.leesia.entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 16:43
 * @Description:
 */
@Service
public class ProvinceResource {

    private String[] PROVINCES = new String[]{
            "北京市", "天津市", "上海市", "重庆市", "河北省", "山西省", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省",
            "安徽省", "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "海南省", "四川省", "贵州省",
            "云南省", "陕西省", "甘肃省", "青海省", "台湾省", "内蒙古自治区", "广西壮族自治区", "西藏自治区",
            "宁夏回族自治区", "新疆维吾尔自治区", "香港特别行政区", "澳门特别行政区"
    };

    @Autowired
    private ProvinceService provinceService;

    private List<Province> createAllProvince() {
        List<Province> provinces = new ArrayList<>();
        for (String provinceName : PROVINCES) {
            Province province = new Province();
            province.setProvinceName(provinceName);
            provinces.add(province);
        }

        return provinces;
    }

    public void insertAllCities() {
        provinceService.batchInsert(createAllProvince());
    }
}
