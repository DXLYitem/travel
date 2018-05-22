package com.example.travel.entity;

import java.io.Serializable;

/**
 * 酒店表
 */
public class Hotel implements Serializable{
    private static final long serialVersionUID = 1L;
    //ID
 private Integer hotelId;
 //酒店名
  private String hotelName;
    //酒店图片路径
  private String picPath;
  //酒店介绍
  private String hotelIntro;
  //酒店星级
  private String star;
  //酒店地址
  private String address;
  //酒店地区ID
  private Integer countryId;
  //房型
  private String roomType;
  //早餐
  private String breakfast;
  //午餐
  private String lunch;
  //晚餐
  private String dinner;
  //酒店描述
  private String hotelDesc;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getHotelIntro() {
        return hotelIntro;
    }

    public void setHotelIntro(String hotelIntro) {
        this.hotelIntro = hotelIntro;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getHotelDesc() {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc) {
        this.hotelDesc = hotelDesc;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", picPath='" + picPath + '\'' +
                ", hotelIntro='" + hotelIntro + '\'' +
                ", star='" + star + '\'' +
                ", address='" + address + '\'' +
                ", countryId=" + countryId +
                ", roomType='" + roomType + '\'' +
                ", breakfast='" + breakfast + '\'' +
                ", lunch='" + lunch + '\'' +
                ", dinner='" + dinner + '\'' +
                ", hotelDesc='" + hotelDesc + '\'' +
                '}';
    }
}
