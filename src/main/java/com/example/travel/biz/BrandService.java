package com.example.travel.biz;

import com.example.travel.entity.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 根据度假ID查询度假套餐表下面的酒店品牌
     * @param holidayId
     * @return
     */
    public List<Brand> listBrand(Integer holidayId);
}
