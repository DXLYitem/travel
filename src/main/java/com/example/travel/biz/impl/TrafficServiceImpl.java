package com.example.travel.biz.impl;

import com.example.travel.biz.TrafficService;
import com.example.travel.dao.TrafficDao;
import com.example.travel.entity.Traffic;
import com.example.travel.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TrafficServiceImpl implements TrafficService {
    @Resource
    private TrafficDao trafficDao;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Traffic> listTraffic(Integer themeId) {
        String trafficKey="trafficKey"+themeId;
        if(redisUtil.exists(trafficKey)){
            Object o = redisUtil.lRange(trafficKey, 0, redisUtil.length(trafficKey)).get(0);
            return (List<Traffic>) o;
        }else{
            List<Traffic> list=trafficDao.selectTraffic(themeId);
            redisUtil.lPush(trafficKey,list);
            return list;
        }

    }
}
