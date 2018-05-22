package com.example.travel.entity;

import java.io.Serializable;

/**
 * 度假套餐表
 */
public class Holiday implements Serializable {
    private static final long serialVersionUID = 1L;
    //套餐ID
    private Integer holidayId;
    //套餐名
    private String holidayName;

    public Integer getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(Integer holidayId) {
        this.holidayId = holidayId;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "holidayId=" + holidayId +
                ", holidayName='" + holidayName + '\'' +
                '}';
    }
}
