package com.example.travel.biz.impl;

import com.example.travel.biz.AssociatorService;
import com.example.travel.dao.AssociatorDao;
import com.example.travel.entity.Associator;
import com.example.travel.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("associatorServiceImpl")
public class AssociatorServiceImpl implements AssociatorService {

    @Autowired
    private AssociatorDao associatorDao;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private CustomizeServiceImpl customizeService;


    @Override
    public int add(Associator associator) {
        return associatorDao.insert(associator);
    }

    /**
     * 查询用户信息
     * @param phone
     * @return
     */
    @Override
    public Associator query(String phone) {
        String key="user"+phone;
        Associator associator=new Associator();
        if(redisUtil.exists(key)){
            associator=(Associator) redisUtil.get(key);
        }else{
            associator=associatorDao.select(phone);
            redisUtil.set(key,associator);
        }
        return associator;
    }

    @Override
    public int quwerCount(String phone) {
        return associatorDao.count(phone);
    }

    @Override
    public int modify(String email, String phone,String name) {
        String key="user"+phone;
        customizeService.modify(email,phone,name);
        int num=associatorDao.update(email,phone,name);
        if(num>0){
            redisUtil.remove(key);
        }
        return num;
    }
}
