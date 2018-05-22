package com.example.travel.entity;

import java.io.Serializable;

/**
 * 旅行主题表
 */
public class Travel implements Serializable {
    private static final long serialVersionUID = 1L;
    //旅行ID
    private Integer travelId;
    //旅行名
    private String travelName;
    //主题ID
    private Integer themeId;

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "travelId=" + travelId +
                ", travelName='" + travelName + '\'' +
                ", themeId=" + themeId +
                '}';
    }
}
