package org.leesia.dataio.dao.ext;

import org.leesia.entity.City;
import org.leesia.entity.LastName;

import java.util.List;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 12:59
 * @Description:
 */
public interface ExtLastNameMapper {

    int bacthInsert(List<LastName> lastNames);
}
