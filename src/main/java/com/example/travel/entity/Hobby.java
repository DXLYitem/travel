package com.example.travel.entity;

import java.io.Serializable;

/**
 * 旅行偏好表
 */
public class Hobby implements Serializable{
    private static final long serialVersionUID = 1L;
    //偏好ID
  private Integer hobbyId;
  //偏好名
  private String hobbyName;
  //主题ID
  private Integer themeId;

    public Integer getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(Integer hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobbyId=" + hobbyId +
                ", hobbyName='" + hobbyName + '\'' +
                ", themeId=" + themeId +
                '}';
    }
}
