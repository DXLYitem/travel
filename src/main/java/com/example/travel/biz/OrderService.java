package com.example.travel.biz;

import com.example.travel.entity.Order;

import java.util.List;

public interface OrderService {
    public int add(Order order);

    public List<Order> orderList(String phone, Integer num);
}
