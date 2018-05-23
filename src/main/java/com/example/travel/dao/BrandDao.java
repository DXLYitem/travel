package com.example.travel.dao;

import com.example.travel.entity.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandDao {
    /**
     * 根据度假ID查询度假套餐表下面的酒店品牌
     * @param holidayId
     * @return
     */
    List<Brand> selectBrand(@Param("holidayId") Integer holidayId);
}
