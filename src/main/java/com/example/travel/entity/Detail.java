package com.example.travel.entity;

import java.io.Serializable;

/**
 * 详细表
 */
public class Detail implements Serializable {
    private static final long serialVersionUID = 1L;
    //ID
    private Integer detailId;
    //项目ID
    private Integer itemId;
    //描述
    private String desc;
    //起价说明1
    private String priceDescOne;
    //起价说明2
    private String priceDesctwo;
    //地图图片路径
    private String mapPath;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPriceDescOne() {
        return priceDescOne;
    }

    public void setPriceDescOne(String priceDescOne) {
        this.priceDescOne = priceDescOne;
    }

    public String getPriceDesctwo() {
        return priceDesctwo;
    }

    public void setPriceDesctwo(String priceDesctwo) {
        this.priceDesctwo = priceDesctwo;
    }

    public String getMapPath() {
        return mapPath;
    }

    public void setMapPath(String mapPath) {
        this.mapPath = mapPath;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "detailId=" + detailId +
                ", itemId=" + itemId +
                ", desc='" + desc + '\'' +
                ", priceDescOne='" + priceDescOne + '\'' +
                ", priceDesctwo='" + priceDesctwo + '\'' +
                ", mapPath='" + mapPath + '\'' +
                '}';
    }
}
