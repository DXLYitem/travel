package com.example.travel.dao;

import com.example.travel.entity.Continent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContinentDao {

    public List<Continent> selectContinent();

    /**
     * 根据度假ID查询度假套餐表下面的区域
     * @param holidayId
     * @return
     */
    List<Continent> selectContinentByholidayId(@Param("holidayId") Integer holidayId);
}
