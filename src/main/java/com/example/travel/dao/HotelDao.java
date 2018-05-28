package com.example.travel.dao;

import com.example.travel.entity.Hotel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelDao {
    public List<Hotel> selHotel(@Param("continentId") Integer continentId);

    /**
     * 根据酒店ID查询酒店信息
     * @param hotelId
     * @return
     */
    List<Hotel>selectByhotelId(@Param("hotelId") Integer hotelId);
}
