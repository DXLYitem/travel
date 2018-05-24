package com.example.travel.biz;

import com.example.travel.entity.Customize;

import java.util.List;

public interface CustomizeService {
    public int addCustomize(Customize customize);

    public int queryId();

    public List<Customize> listCustomize(String phone);
}
