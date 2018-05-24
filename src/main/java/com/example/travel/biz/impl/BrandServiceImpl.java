package com.example.travel.biz.impl;

import com.example.travel.biz.BrandService;
import com.example.travel.dao.BrandDao;
import com.example.travel.entity.Brand;
import com.example.travel.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandDao brandDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public List<Brand> listBrand(Integer holidayId) {
        List<Brand> list=brandDao.selectBrand(holidayId);
        return list;
    }
}
