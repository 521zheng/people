package org.leesia.util;

import java.util.UUID;

/**
 * @Auther: leesia
 * @Date: 2018/8/8 12:42
 * @Description:
 */
public final class UUIDTool {

    private UUIDTool() {
    }

    /**
     * 获取UUID
     * @return uuid
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {
        System.out.println(UUIDTool.uuid());
    }
}
