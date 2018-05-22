package com.example.travel.biz.impl;

import com.example.travel.biz.TravelService;
import com.example.travel.dao.TravelDao;
import com.example.travel.entity.Country;
import com.example.travel.entity.Travel;
import com.example.travel.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private TravelDao travelDao;



    @Override
    public List<Travel> listTravel(Integer themeId) {
        String trKey="trKey"+themeId;
        /*redisUtil.remove(couKey);*/
        if(redisUtil.exists(trKey)){
            Object o = redisUtil.lRange(trKey, 0, redisUtil.length(trKey)).get(0);
            return (List<Travel>) o;
        }else{
            List<Travel> list=travelDao.selectTravel(themeId);
            redisUtil.lPush(trKey,list);
            return list;
        }
    }
}
