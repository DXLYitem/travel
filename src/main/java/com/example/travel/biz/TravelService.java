package com.example.travel.biz;

import com.example.travel.entity.Travel;

import java.util.List;

public interface TravelService {

    public List<Travel> listTravel(Integer themeId);
}
