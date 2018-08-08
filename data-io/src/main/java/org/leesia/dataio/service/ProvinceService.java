package org.leesia.dataio.service;

import org.leesia.entity.Province;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 09:02
 * @Description:
 */
public interface ProvinceService {

    int insert(Province province);

    int batchInsert(List<Province> provinces);

    List<Province> get(Map<String, Object> params);

    Province getByName(String provinceName);

    int delete(Province province);

    int update(Province province);
}
