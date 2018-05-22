package com.example.travel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    //ID
    private Integer orderId;
    //订单号
    private String orderNum;
    //下单时间
    private Date orderTime;
    //订单金额
    private Double price;
    //目的地
    private String destination;
    //订单状态
    private String status;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", price=" + price +
                ", destination='" + destination + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
