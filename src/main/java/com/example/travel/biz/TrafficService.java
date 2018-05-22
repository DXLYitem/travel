package com.example.travel.biz;

import com.example.travel.entity.Traffic;

import java.util.List;

public interface TrafficService {
    public List<Traffic> listTraffic(Integer themeId);
}
