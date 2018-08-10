package org.leesia.dataio.service;

import org.leesia.entity.LastName;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/9 09:00
 * @Description:
 */
public interface LastNameService {

    int insert(LastName lastName);

    int batchInsert(List<LastName> lastNames);

    List<LastName> get(Map<String, Object> params);

    LastName getByName(String lastName);

    int delete(LastName lastName);

    int update(LastName lastName);
}
