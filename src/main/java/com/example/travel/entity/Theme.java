package com.example.travel.entity;

import java.io.Serializable;

public class Theme implements Serializable{
    private static final long serialVersionUID = 1L;
    //主题ID
  private Integer themeId;
  //主题名
  private String themeName;

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "themeId=" + themeId +
                ", themeName='" + themeName + '\'' +
                '}';
    }
}
