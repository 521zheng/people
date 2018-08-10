package org.leesia.dataio.service;

import org.leesia.entity.Nation;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/9 13:55
 * @Description:
 */
public interface NationService {

    int insert(Nation nation);

    int batchInsert(List<Nation> nations);

    List<Nation> get(Map<String, Object> params);

    Nation getByName(String nationName);

    int delete(Nation nation);

    int update(Nation nation);
}
