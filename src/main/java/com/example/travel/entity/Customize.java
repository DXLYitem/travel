package com.example.travel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 私人定制表
 */
public class Customize implements Serializable {
    private static final long serialVersionUID = 1L;
    //ID
    private Integer customizeId;
    //目的地（下拉框选择）
    private Integer destination;
    //出行人数
    private Integer tripsNum;
    //联系人
    private String contact;
    //联系电话
    private String phone;
    //邮箱
    private String email;
    //出发日期
    private Date startDate;
    //结束日期
    private Date endDate;
    //航班时间
    private String flightTime;
    //航班舱位（下拉框选择）
    private String flightSpace;
    //航空公司
    private String flightCompany;
    //指定酒店（下拉框选择）
    private String hotel;
    //酒店房型（下拉框选择）
    private String roomType;
    //行程节奏
    private String rhythm;
    //游览项目（下拉框选择）
    private String tourProject;
    //餐食要求
    private String meal;
    //其他需求
    private String other;
    //出发日期
    private String startDateString;
    //结束日期
    private String endDateString;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCustomizeId() {
        return customizeId;
    }

    public void setCustomizeId(Integer customizeId) {
        this.customizeId = customizeId;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public Integer getTripsNum() {
        return tripsNum;
    }

    public void setTripsNum(Integer tripsNum) {
        this.tripsNum = tripsNum;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightSpace() {
        return flightSpace;
    }

    public void setFlightSpace(String flightSpace) {
        this.flightSpace = flightSpace;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRhythm() {
        return rhythm;
    }

    public void setRhythm(String rhythm) {
        this.rhythm = rhythm;
    }

    public String getTourProject() {
        return tourProject;
    }

    public void setTourProject(String tourProject) {
        this.tourProject = tourProject;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getStartDateString() {
        return startDateString;
    }

    public void setStartDateString(String startDateString) {
        this.startDateString = startDateString;
    }

    public String getEndDateString() {
        return endDateString;
    }

    public void setEndDateString(String endDateString) {
        this.endDateString = endDateString;
    }

    @Override
    public String toString() {
        return "Customize{" +
                "customizeId=" + customizeId +
                ", destination=" + destination +
                ", tripsNum=" + tripsNum +
                ", contact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", flightTime=" + flightTime +
                ", flightSpace='" + flightSpace + '\'' +
                ", flightCompany='" + flightCompany + '\'' +
                ", hotel='" + hotel + '\'' +
                ", roomType='" + roomType + '\'' +
                ", rhythm='" + rhythm + '\'' +
                ", tourProject='" + tourProject + '\'' +
                ", meal='" + meal + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
