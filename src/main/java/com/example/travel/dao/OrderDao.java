package com.example.travel.dao;

import com.example.travel.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    public int insert(Order order);

    public List<Order> selOrder(@Param("phone") String phone);

    public List<Order> selscores(@Param("phone")String phone);
}
