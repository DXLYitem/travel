package com.example.travel.biz;

import com.example.travel.entity.Hotel;

import java.util.List;

public interface HotelService {
    public List<Hotel> listHotel(Integer continentId);
}
