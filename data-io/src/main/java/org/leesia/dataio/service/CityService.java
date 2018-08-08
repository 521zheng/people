package org.leesia.dataio.service;

import org.leesia.entity.City;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 08:58
 * @Description:
 */
public interface CityService {

    int insert(City city);

    int batchInsert(List<City> cities);

    List<City> get(Map<String, Object> params);

    City getByName(String cityName);

    int delete(City city);

    int update(City city);
}
