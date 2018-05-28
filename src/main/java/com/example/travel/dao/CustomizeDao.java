package com.example.travel.dao;

import com.example.travel.entity.Customize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomizeDao {
    public int submit(Customize customize);

    public int selId();

    public Customize selCustomize(@Param("id") Integer id);

    public int update(@Param("email") String email, @Param("phone") String phone, @Param("name") String name);
}
