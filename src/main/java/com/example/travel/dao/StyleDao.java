package com.example.travel.dao;

import com.example.travel.entity.Style;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StyleDao {

    public List<Style> selectStyle(@Param("themeId") Integer themeId);
}
