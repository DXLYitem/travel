package com.example.travel.biz;

import com.example.travel.entity.Hotel;

import java.util.List;

public interface HotelService {
    public List<Hotel> listHotel(Integer continentId);

    /**
     * 根据酒店ID查询酒店信息
     * @param hotelId
     * @return
     */
    List<Hotel>findByhotelId(Integer hotelId);
}
