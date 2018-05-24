package com.example.travel.entity;

import java.io.Serializable;

/**
 * 地域表
 */
public class Continent implements Serializable {
    private static final long serialVersionUID = 1L;
    //地域ID
    private Integer continentId;
    // 地域名
    private String continentName;

    //套餐ID
    private Integer holidayId;

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public Integer getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(Integer holidayId) {
        this.holidayId = holidayId;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "continentId=" + continentId +
                ", continentName='" + continentName + '\'' +
                ", holidayId=" + holidayId +
                '}';
    }
}
