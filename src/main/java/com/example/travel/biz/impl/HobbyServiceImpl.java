package com.example.travel.biz.impl;

import com.example.travel.biz.HobbyService;
import com.example.travel.dao.HobbyDao;
import com.example.travel.entity.Country;
import com.example.travel.entity.Hobby;
import com.example.travel.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HobbyServiceImpl implements HobbyService {
    @Resource
    private HobbyDao hobbyDao;
    @Resource
    private RedisUtil redisUtil;


    @Override
    public List<Hobby> listHobby(Integer themeId) {
       /* String hoKey="hoKey"+themeId;
        *//*redisUtil.remove(couKey);*//*
        if(redisUtil.exists(hoKey)){
            Object o = redisUtil.lRange(hoKey, 0, redisUtil.length(hoKey)).get(0);
            return (List<Hobby>) o;
        }else{*/
            List<Hobby> list=hobbyDao.selectHobby(themeId);
          //  redisUtil.lPush(hoKey,list);
            return list;
      //  }

    }
}
