package com.example.travel.dao;

import com.example.travel.entity.Customize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomizeDao {
    public int submit(Customize customize);

    public int selId();

    public List<Customize> selCustomize(@Param("phone") String phone);
}
