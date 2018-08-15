package org.leesia.entity;

import java.io.Serializable;
import java.util.Date;

public class ProvinceDistribution implements Serializable {
    private String id;

    private String provinceName;

    private Double distribution;

    private String nationDistribution;

    private String sexDistribution;

    private String lastNameDistribution;

    private Date createDatetime;

    private Date updateDatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Double getDistribution() {
        return distribution;
    }

    public void setDistribution(Double distribution) {
        this.distribution = distribution;
    }

    public String getNationDistribution() {
        return nationDistribution;
    }

    public void setNationDistribution(String nationDistribution) {
        this.nationDistribution = nationDistribution;
    }

    public String getSexDistribution() {
        return sexDistribution;
    }

    public void setSexDistribution(String sexDistribution) {
        this.sexDistribution = sexDistribution;
    }

    public String getLastNameDistribution() {
        return lastNameDistribution;
    }

    public void setLastNameDistribution(String lastNameDistribution) {
        this.lastNameDistribution = lastNameDistribution;
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