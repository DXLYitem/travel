package com.example.travel.dao;

import com.example.travel.entity.Order;

import java.util.List;

public interface OrderDao {
    public int insert(Order order);

    public List<Order> selOrder(String phone);
}
