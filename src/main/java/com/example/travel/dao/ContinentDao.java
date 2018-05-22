package com.example.travel.dao;

import com.example.travel.entity.Continent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContinentDao {

    public List<Continent> selectContinent(@Param("continentId") Integer continentId );
}
