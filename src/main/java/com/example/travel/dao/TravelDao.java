package com.example.travel.dao;

import com.example.travel.entity.Travel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TravelDao {

    public List<Travel> selectTravel(@Param("themeId") Integer ThemeId);
}
