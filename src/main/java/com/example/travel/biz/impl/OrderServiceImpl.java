package com.example.travel.biz.impl;

import com.example.travel.biz.OrderService;
import com.example.travel.dao.OrderDao;
import com.example.travel.entity.Order;
import com.example.travel.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int add(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public List<Order> orderList(String phone) {
        String key="order"+phone;
        List<Order> order=new ArrayList<Order>();
        if(redisUtil.exists(key)){
            order=(List<Order>) redisUtil.lRange(key,0,redisUtil.length(key)).get(0);
        }else{
            order=orderDao.selOrder(phone);
            redisUtil.lPush(key,order);
        }
        return order;
    }
}
