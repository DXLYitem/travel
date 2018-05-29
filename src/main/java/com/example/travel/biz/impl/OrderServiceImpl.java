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
    private int pagesize=1;
    private int count=0;
    private int pagesize1=1;
    private Double summoney=0.0;

    /**
     * 添加订单
     * @param order
     * @return
     */
    @Override
    public int add(Order order) {
        return orderDao.insert(order);
    }

    /**
     * 查询订单
     * @param phone
     * @param num
     * @return
     */
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
            pagesize++;
        }
        for (int i=0;i<ordernum;i++){
            if(i>=order.size()){
                break;
            }
            order.get(i).setPageNo(order.size());
            order.get(i).setPageSize(pagesize);
            orderList.add(order.get(i));
        }
        return orderList;
    }

    /**
     * 查询积分
     * @param phone
     * @return
     */
    @Override
    public List<Order> queryScores(String phone,String num) {
        String key="scores"+phone;
        List<Order> list=new ArrayList<>();
        List<Order> orderList=new ArrayList<>();
        if(num!=null){
            count=Integer.parseInt(num)+1;
        }else{
            count=count+1;
            pagesize1++;
        }
        if(redisUtil.exists(key)){
            list=(List<Order>)redisUtil.lRange(key,0,redisUtil.length(key)).get(0);
        }else{
            list=orderDao.selscores(phone);
            for (int i=0;i<list.size();i++){
                summoney=list.get(i).getPrice();
            }
            redisUtil.lPush(key,list);
        }
        for(int i=0;i<count;i++){
            if(i>=list.size()){
                break;
            }
            list.get(i).setPageNo(list.size());
            list.get(i).setPageSize(pagesize1);
            list.get(i).setTotalmoney(summoney);
            orderList.add(list.get(i));
        }
        return orderList;
    }
}
