package org.leesia.enums;

/**
 * @Auther: leesia
 * @Date: 2018/8/15 12:48
 * @Description:
 */
public enum Sex {
    MALE(0, "男性"),
    FEMALE(1, "女性"),
    ;

    private Sex(int sex, String desc) {
        this.sex = sex;
        this.desc = desc;
    }

    private int sex;

    private String desc;

    public int getSex() {
        return sex;
    }

    public String getDesc() {
        return desc;
    }
}
