package com.example.travel.entity;

import java.io.Serializable;

/**
 *
 旅行方式表
 */
public class Style implements Serializable {
    private static final long serialVersionUID = 1L;
    //方式ID
    private Integer styleId;
    //方式名
    private String styleName;
    //主题ID
    private Integer theme;

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public Integer getTheme() {
        return theme;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Style{" +
                "styleId=" + styleId +
                ", styleName='" + styleName + '\'' +
                ", theme=" + theme +
                '}';
    }
}
