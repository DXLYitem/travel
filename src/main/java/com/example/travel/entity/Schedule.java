package com.example.travel.entity;

import java.io.Serializable;

/**
 * 行程表
 */
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    //ID
    private Integer scheduleId;
    //项目表ID
    private Integer itemId;
    //风景图片路径
    private String imgPath;
    //标题
    private String title;
    //说明
    private String explain;
    //酒店ID
    private Integer hotelId;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", itemId=" + itemId +
                ", imgPath='" + imgPath + '\'' +
                ", title='" + title + '\'' +
                ", explain='" + explain + '\'' +
                ", hotelId=" + hotelId +
                '}';
    }
}
