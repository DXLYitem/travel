package com.example.travel.dao;

import com.example.travel.entity.Traffic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrafficDao {

    public List<Traffic> selectTraffic(@Param("themeId") Integer themeId);
}
