package org.leesia.dataio.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.leesia.dataio.dao.CityMapper;
import org.leesia.dataio.dao.ExtCityMapper;
import org.leesia.dataio.redis.RedisService;
import org.leesia.dataio.service.CityService;
import org.leesia.entity.City;
import org.leesia.entity.CityCriteria;
import org.leesia.entity.Province;
import org.leesia.entity.ProvinceCriteria;
import org.leesia.util.UUIDTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 08:58
 * @Description:
 */
@Service
public class CityServiceImpl implements CityService {

    private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityMapper mapper;

    @Autowired
    private ExtCityMapper extMapper;

    @Autowired
    RedisService redisService;

    @Override
    public int insert(City city) {
        logger.info("增加城市：{}", city.getCityName());
        if (StringUtils.isBlank(city.getId())) {
            city.setId(UUIDTools.uuid());
        }
        int insert = mapper.insertSelective(city);
        redisService.setObject(city.getCityName(), city, 60, TimeUnit.SECONDS);

        return insert;
    }

    @Override
    public int batchInsert(List<City> cities) {
        logger.info("批量增加城市：{}", cities.size());
        if (cities.isEmpty()) {
            logger.error("批量增加城市失败，没有要添加的城市");
            return 0;
        }
        for (City city : cities) {
            if (StringUtils.isBlank(city.getId())) {
                city.setId(UUIDTools.uuid());
            }
            if (city.getCreateDatetime() == null) {
                city.setCreateDatetime(new Date());
            }
            if (city.getUpdateDatetime() == null) {
                city.setUpdateDatetime(new Date());
            }
        }
        return extMapper.bacthInsert(cities);
    }

    @Override
    public List<City> get(Map<String, Object> params) {
        logger.info("查询城市：{}", params);
        CityCriteria criteria = createCriteria(params);
        return mapper.selectByExample(criteria);
    }

    @Override
    public City getByName(String cityName) {
        logger.info("查询城市：{}", cityName);
        City city = (City) redisService.getObject(cityName);
        if (city == null) {
            Map<String, Object> params = new HashMap<>();
            params.put("cityName", "cityName");
            CityCriteria criteria = createCriteria(params);
            List<City> cities = mapper.selectByExample(criteria);

            if (cities != null && !cities.isEmpty()) {
                city = cities.get(0);
                redisService.setObject(cityName, city, 60, TimeUnit.SECONDS);
            }
        }

        return city;
    }

    @Override
    public int delete(City city) {
        logger.info("删除城市：{}", city.getId());
        if (StringUtils.isBlank(city.getId())) {
            logger.error("删除城市失败，主键为空");
            return 0;
        }
        int delete = mapper.deleteByPrimaryKey(city.getId());
        redisService.deleteObject(city.getCityName());

        return delete;
    }

    @Override
    public int update(City city) {
        logger.info("更新城市：{}", city.getId());
        if (StringUtils.isBlank(city.getId())) {
            logger.error("更新城市失败，主键为空");
            return 0;
        }
        int update = mapper.updateByPrimaryKeySelective(city);
        redisService.setObject(city.getCityName(), city, 60, TimeUnit.SECONDS);

        return update;
    }

    private CityCriteria createCriteria(Map<String, Object> params) {
        CityCriteria criteria = new CityCriteria();
        CityCriteria.Criteria c = criteria.createCriteria();

        String id = (String) params.get("id");
        if (StringUtils.isNotBlank(id)) {
            c.andIdEqualTo(id);
        }

        String cityName = (String) params.get("cityName");
        if (StringUtils.isNotBlank(cityName)) {
            c.andCityNameLike("%" + cityName + "%");
        }

        String province = (String) params.get("province");
        if (StringUtils.isNotBlank(province)) {
            c.andProvinceLike("%" + province + "%");
        }

        String provinceName = (String) params.get("provinceName");
        if (StringUtils.isNotBlank(provinceName)) {
            c.andProvinceNameLike("%" + provinceName + "%");
        }

        return criteria;
    }
}
