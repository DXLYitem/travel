package com.example.travel.dao;

import com.example.travel.entity.Holiday;

import java.util.List;

/**
 * 度假套餐DAO层
 */
public interface HolidayDao {

    /**
     * 查询所有度假套餐
     * @return
     */
    List<Holiday> selectHoliday();
}
