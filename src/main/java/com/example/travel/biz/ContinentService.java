package com.example.travel.biz;

import com.example.travel.entity.Continent;



import java.util.List;


public interface ContinentService {
    public List<Continent> listContinent();

    /**
     * 根据度假ID查询度假套餐表下面的区域
     * @param holidayId
     * @return
     */
    List<Continent> listContinentByholidayId(Integer holidayId);
}
