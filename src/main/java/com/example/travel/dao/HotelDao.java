package com.example.travel.dao;

import com.example.travel.entity.Hotel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelDao {
    public List<Hotel> selHotel(@Param("continentId") Integer continentId);
}
