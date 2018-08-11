package org.leesia.entity;

import java.util.Date;

public class LastNameDistribution {
    private String id;

    private String lastName;

    private Double distribution;

    private Date createDatetime;

    private Date updateDatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getDistribution() {
        return distribution;
    }

    public void setDistribution(Double distribution) {
        this.distribution = distribution;
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