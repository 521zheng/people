package org.leesia.dataio.dao.ext;

import org.leesia.entity.Hanzi;

import java.util.List;

/**
 * @Auther: leesia
 * @Date: 2018/8/10 13:22
 * @Description:
 */
public interface ExtHanziMapper {

    int bacthInsert(List<Hanzi> hanzis);
}
