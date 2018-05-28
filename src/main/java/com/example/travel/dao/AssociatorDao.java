package com.example.travel.dao;

import com.example.travel.entity.Associator;
import org.apache.ibatis.annotations.Param;

public interface AssociatorDao {
    public int insert(Associator associator);

    public Associator select(@Param("phone") String phone);

    public int count(@Param("phone") String phone);

    public int update(@Param("email") String email, @Param("phone") String phone, @Param("name") String name);
}
