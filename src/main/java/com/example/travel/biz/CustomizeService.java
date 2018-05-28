package com.example.travel.biz;

import com.example.travel.entity.Customize;
import com.example.travel.entity.Order;

import java.util.List;

public interface CustomizeService {
    public int addCustomize(Customize customize,Order order);

    public int queryId();

    public Customize listCustomize(Integer id);

    public int modify(String email,String phone,String name);
}
