package com.example.travel.biz.impl;

import com.example.travel.biz.ScheduleService;
import com.example.travel.dao.ScheduleDao;
import com.example.travel.entity.Schedule;
import com.example.travel.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ScheduleServiceImpl implements ScheduleService{
    @Resource
    private ScheduleDao scheduleDao;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Schedule> findByitemId(Integer itemId) {
      String key="key"+itemId;
      if(redisUtil.exists(key)){
          Object itId = redisUtil.lRange(key, 0, redisUtil.length(key)).get(0);
          return (List<Schedule>) itId;
      } else {
          List<Schedule> ScheduleList = scheduleDao.selectSchedule(itemId);
          redisUtil.lPush("ScheduleList", ScheduleList);
          return ScheduleList;
      }
    }
}
