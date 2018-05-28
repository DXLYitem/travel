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
    private int ordernum=0;

    @Override
    public int add(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public List<Order> orderList(String phone,Integer num) {
        String key="order"+phone;
        List<Order> order=new ArrayList<Order>();
        List<Order> orderList=new ArrayList<>();
        redisUtil.remove(key);
        if(redisUtil.exists(key)){
            order=(List<Order>) redisUtil.lRange(key,0,redisUtil.length(key)).get(0);
        }else{
            order=orderDao.selOrder(phone);
            redisUtil.lPush(key,order);
        }
        if(num!=null){
            ordernum=num+1;
        }else{
            ordernum=ordernum+1;
        }
        for (int i=0;i<ordernum;i++){
            if(i>=order.size()){
                break;
            }
            orderList.add(order.get(i));
        }
        return orderList;
    }
}
