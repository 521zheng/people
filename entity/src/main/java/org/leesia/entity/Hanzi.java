package org.leesia.entity;

import java.io.Serializable;
import java.util.Date;

public class Hanzi implements Serializable {
    private String id;

    private String hanzi;

    private Boolean isName;

    private Boolean isSecond;

    private Boolean isThird;

    private Boolean isMale;

    private Boolean isFemale;

    private Boolean malePerfect;

    private Boolean femalePerfect;

    private Date createDatetime;

    private Date updateDatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHanzi() {
        return hanzi;
    }

    public void setHanzi(String hanzi) {
        this.hanzi = hanzi;
    }

    public Boolean getIsName() {
        return isName;
    }

    public void setIsName(Boolean isName) {
        this.isName = isName;
    }

    public Boolean getIsSecond() {
        return isSecond;
    }

    public void setIsSecond(Boolean isSecond) {
        this.isSecond = isSecond;
    }

    public Boolean getIsThird() {
        return isThird;
    }

    public void setIsThird(Boolean isThird) {
        this.isThird = isThird;
    }

    public Boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(Boolean isMale) {
        this.isMale = isMale;
    }

    public Boolean getIsFemale() {
        return isFemale;
    }

    public void setIsFemale(Boolean isFemale) {
        this.isFemale = isFemale;
    }

    public Boolean getMalePerfect() {
        return malePerfect;
    }

    public void setMalePerfect(Boolean malePerfect) {
        this.malePerfect = malePerfect;
    }

    public Boolean getFemalePerfect() {
        return femalePerfect;
    }

    public void setFemalePerfect(Boolean femalePerfect) {
        this.femalePerfect = femalePerfect;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}