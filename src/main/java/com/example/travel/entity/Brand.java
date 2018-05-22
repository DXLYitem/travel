package com.example.travel.entity;

import java.io.Serializable;

/**
 * 酒店品牌
 */
public class Brand implements Serializable{
    private static final long serialVersionUID = 1L;
    //酒店ID
    private Integer brandId;
    //套餐ID
    private String brandName;
    //酒店名
    private Integer holidayId;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(Integer holidayId) {
        this.holidayId = holidayId;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", holidayId=" + holidayId +
                '}';
    }
}
