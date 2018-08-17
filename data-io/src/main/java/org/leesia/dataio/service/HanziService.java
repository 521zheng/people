package org.leesia.dataio.service;

import org.leesia.entity.Hanzi;

import java.util.List;
import java.util.Map;

/**
 * @Auther: leesia
 * @Date: 2018/8/10 13:13
 * @Description:
 */
public interface HanziService {

    int insert(Hanzi hanzi);

    int batchInsert(List<Hanzi> hanzis);

    List<Hanzi> get(Map<String, Object> params);

    Hanzi getByName(String hanziName);

    int delete(Hanzi hanzi);

    int update(Hanzi hanzi);
}
