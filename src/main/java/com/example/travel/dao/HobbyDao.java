package com.example.travel.dao;

import com.example.travel.entity.Hobby;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HobbyDao {

    public List<Hobby> selectHobby(@Param("themeId") Integer themeId);
}
