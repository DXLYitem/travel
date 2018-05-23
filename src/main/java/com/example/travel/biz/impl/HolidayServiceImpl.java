package com.example.travel.biz.impl;

import com.example.travel.biz.HolidayService;
import com.example.travel.dao.HolidayDao;
import com.example.travel.entity.Holiday;
import com.example.travel.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {
    @Resource
    private HolidayDao holidayDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public List<Holiday> listHoliday() {
        if(redisUtil.exists("hoKey")){
            Object o = redisUtil.lRange("hoKey", 0, redisUtil.length("hoKey")).get(0);
            return (List<Holiday>) o;
        }else{
            List<Holiday> list=holidayDao.selectHoliday();
            redisUtil.lPush("hoKey",list);
            return list;
        }
    }
}
