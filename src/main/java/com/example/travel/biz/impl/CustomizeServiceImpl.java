package com.example.travel.biz.impl;

import com.example.travel.biz.CustomizeService;
import com.example.travel.dao.CustomizeDao;
import com.example.travel.entity.Associator;
import com.example.travel.entity.Customize;
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
    private AssociatorServiceImpl associatorServiceImpl;

    @Override
    public int addCustomize(Customize customize) {
        Associator associator=new Associator();
        associator.setEmail(customize.getEmail());
        associator.setPhone(customize.getPhone());
        associator.setUsername(customize.getContact());
        associator.setScores(0.0);
        int no=associatorServiceImpl.add(associator);
        int num=customizeDao.submit(customize);
        //根据id和联系人生成缓存的键
        String id=queryId()+customize.getContact();
        String userkey="user"+customize.getPhone();
        redisUtil.set(userkey,associator);
        redisUtil.set(id,customize);
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
    public List<Customize> listCustomize(String phone) {
        String userkey="userlist"+phone;
        List<Customize> list=null;
        if(redisUtil.exists(userkey)){
            list = (List<Customize>) redisUtil.lRange(userkey, 0, redisUtil.length(userkey)).get(0);
        }else{
            list=customizeDao.selCustomize(phone);
            redisUtil.lPush(userkey,list);
        }
        return list;
    }
}
