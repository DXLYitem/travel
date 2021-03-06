package com.example.travel.biz.impl;

import com.example.travel.biz.HotelService;
import com.example.travel.dao.HotelDao;
import com.example.travel.entity.Country;
import com.example.travel.entity.Hotel;
import com.example.travel.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hotelServiceImpl")
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Hotel> listHotel(Integer continentId) {
        String key="hotel"+continentId;
        List<Hotel> hotels=null;
        if (redisUtil.exists(key)){
            hotels =(List<Hotel>) redisUtil.lRange(key, 0, redisUtil.length(key)).get(0);
        }else{
            hotels=hotelDao.selHotel(continentId);
            redisUtil.lPush(key,hotels);
        }
        return hotels;
    }

    @Override
    public List<Hotel> findByhotelId(Integer hotelId) {
        String kedy = "kedy" + hotelId;
        if (redisUtil.exists(kedy)) {
            Object o = redisUtil.lRange(kedy, 0, redisUtil.length(kedy)).get(0);
            return (List<Hotel>) o;
        } else {
            List<Hotel> list = hotelDao.selectByhotelId(hotelId);
            redisUtil.lPush(kedy, list);
            return list;
        }
    }
}
