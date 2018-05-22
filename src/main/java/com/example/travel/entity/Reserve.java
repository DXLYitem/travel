package com.example.travel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 预订表
 */
public class Reserve implements Serializable {
    private static final long serialVersionUID = 1L;
    //ID
    private Integer reserveId;
    //成人
    private Integer adult;
    //儿童
    private Integer child;
    //房间数
    private Integer roomNum;
    //出发日期
    private Date startDate;
    //返回日期
    private Date returnDate;
    //返回日期
    private String city;
    //出发城市
    private String contactName;
    //手机号
    private String phone;

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public Integer getAdult() {
        return adult;
    }

    public void setAdult(Integer adult) {
        this.adult = adult;
    }

    public Integer getChild() {
        return child;
    }

    public void setChild(Integer child) {
        this.child = child;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "reserveId=" + reserveId +
                ", adult=" + adult +
                ", child=" + child +
                ", roomNum=" + roomNum +
                ", startDate=" + startDate +
                ", returnDate=" + returnDate +
                ", city='" + city + '\'' +
                ", contactName='" + contactName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
