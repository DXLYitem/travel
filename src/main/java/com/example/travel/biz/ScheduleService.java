package com.example.travel.biz;

import com.example.travel.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule>findByitemId(Integer itemId);
}
