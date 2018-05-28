package com.example.travel.biz.impl;

import com.example.travel.biz.AssociatorService;
import com.example.travel.biz.CustomizeService;
import com.example.travel.dao.CustomizeDao;
import com.example.travel.dao.OrderDao;
import com.example.travel.entity.Associator;
import com.example.travel.entity.Customize;
import com.example.travel.entity.Order;
import com.example.travel.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customizeServiceImpl")

public class CustomizeServiceImpl implements CustomizeService {

    @Autowired
    private CustomizeDao customizeDao;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private AssociatorService associatorService;
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Override
    public int addCustomize(Customize customize, Order order) {
        Associator associator=new Associator();
        associator.setEmail(customize.getEmail());
        associator.setPhone(customize.getPhone());
        associator.setUsername(customize.getContact());
        associator.setScores(0.0);
        int num=customizeDao.submit(customize);
        int aa=queryId();
        int aaa=associatorService.quwerCount(associator.getPhone());
        Associator at=associatorService.query(associator.getPhone());
        if(at==null){
            int no=associatorService.add(associator);
        }else{
            if(associator.getEmail()!=null&&at.getEmail()==null){
                associatorService.modify(associator.getEmail(),at.getPhone(),associator.getUsername());
            }
        }
        order.setCustomizeid(aa);
        orderServiceImpl.add(order);
        String orderkey="order"+customize.getPhone();
        String userkey="userlist"+customize.getPhone();
        if(redisUtil.exists(userkey)){
            redisUtil.remove(userkey);
        }
        if(redisUtil.exists(orderkey)){
            redisUtil.remove(orderkey);
        }
        return num;
    }

    @Override
    public int queryId() {
        return customizeDao.selId();
    }

    /**
     * 查询用户预订的订单
     * @param phone
     * @return
     */
    @Override
    public Customize listCustomize(Integer id) {
        String userkey="userlist"+id;
        Customize customize=null;
        if(redisUtil.exists(userkey)){
            customize= (Customize) redisUtil.get(userkey);
        }else{
            customize=customizeDao.selCustomize(id);
            redisUtil.set(userkey,customize);
        }
        return customize;
    }

    /**
     * 根据电话修改邮箱
     * @param email
     * @param phone
     * @return
     */
    @Override
    public int modify(String email, String phone,String name) {
        return customizeDao.update(email,phone,name);
    }

}
