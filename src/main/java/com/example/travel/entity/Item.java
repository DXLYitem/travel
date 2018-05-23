package com.example.travel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 旅游项目表
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    //ID
    private Integer itemId;
    //地区ID
    private Integer countryId;
    //标题
    private String title;
    //说明
    private String explain;
    //游玩时间
    private String playTime;
    //价格
    private Double price;
    //出发时间
    private Date startTime;
    //出发城市
    private String city;
    //起价说明
    private String priceDesc;
    //详细ID
    private Integer detailId;
    //偏好ID
    private Integer hobbyId;
    //旅行主题ID
    private Integer travelId;
    //交通ID
    private Integer trafficId;
    //旅行方式ID
    private Integer styleId;

    //偏好名
    private String hobbyName;
    //方式名
    private String styleName;
    //主题名
    private String themeName;
    //交通名
    private String trafficName;
    //旅行名
    private String travelName;

    private Integer continentId;

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getTrafficName() {
        return trafficName;
    }

    public void setTrafficName(String trafficName) {
        this.trafficName = trafficName;
    }

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
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

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPriceDesc() {
        return priceDesc;
    }

    public void setPriceDesc(String priceDesc) {
        this.priceDesc = priceDesc;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(Integer hobbyId) {
        this.hobbyId = hobbyId;
    }

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }

    public Integer getTrafficId() {
        return trafficId;
    }

    public void setTrafficId(Integer trafficId) {
        this.trafficId = trafficId;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }


    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", countryId=" + countryId +
                ", title='" + title + '\'' +
                ", explain='" + explain + '\'' +
                ", playTime='" + playTime + '\'' +
                ", price=" + price +
                ", startTime=" + startTime +
                ", city='" + city + '\'' +
                ", priceDesc='" + priceDesc + '\'' +
                ", detailId=" + detailId +
                ", hobbyId=" + hobbyId +
                ", travelId=" + travelId +
                ", trafficId=" + trafficId +
                ", styleId=" + styleId +
                ", hobbyName='" + hobbyName + '\'' +
                ", styleName='" + styleName + '\'' +
                ", themeName='" + themeName + '\'' +
                ", trafficName='" + trafficName + '\'' +
                ", travelName='" + travelName + '\'' +
                '}';
    }
}
