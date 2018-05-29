package com.example.travel.dao;

import com.example.travel.entity.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleDao {
    List<Schedule>selectSchedule(@Param("itemId") Integer itemId);
}
