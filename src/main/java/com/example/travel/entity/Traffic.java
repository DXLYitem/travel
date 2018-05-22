package com.example.travel.entity;

import java.io.Serializable;

/**
 * 交通工具表
 */
public class Traffic implements Serializable {
    private static final long serialVersionUID = 1L;
    //交通ID
    private Integer trafficId;
    //交通名
    private String trafficName;
    //主题ID
    private Integer themeId;

    public Integer getTrafficId() {
        return trafficId;
    }

    public void setTrafficId(Integer trafficId) {
        this.trafficId = trafficId;
    }

    public String getTrafficName() {
        return trafficName;
    }

    public void setTrafficName(String trafficName) {
        this.trafficName = trafficName;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    @Override
    public String toString() {
        return "Traffic{" +
                "trafficId=" + trafficId +
                ", trafficName='" + trafficName + '\'' +
                ", themeId=" + themeId +
                '}';
    }
}
