package com.example.travel.dao;

import com.example.travel.entity.Country;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountryDao {

    public List<Country> selectCountry(@Param("continentId") Integer continentId);
}
