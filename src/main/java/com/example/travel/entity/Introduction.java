package com.example.travel.entity;

import java.io.Serializable;

/**
 * 介绍表
 */
public class Introduction implements Serializable {
    private static final long serialVersionUID = 1L;
    //ID
    private Integer introduId;
    //详细ID
    private Integer detailId;
    //标题
    private String title;
    //说明
    private String explain;

    public Integer getIntroduId() {
        return introduId;
    }

    public void setIntroduId(Integer introduId) {
        this.introduId = introduId;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
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

    @Override
    public String toString() {
        return "Introduction{" +
                "introduId=" + introduId +
                ", detailId=" + detailId +
                ", title='" + title + '\'' +
                ", explain='" + explain + '\'' +
                '}';
    }
}
