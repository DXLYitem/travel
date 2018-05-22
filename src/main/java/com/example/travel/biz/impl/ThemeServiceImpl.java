package com.example.travel.biz.impl;

import com.example.travel.biz.ThemeService;
import com.example.travel.dao.ThemeDao;
import com.example.travel.entity.Country;
import com.example.travel.entity.Theme;
import com.example.travel.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ThemeServiceImpl implements ThemeService {
    @Resource
    private ThemeDao themeDao;
    @Resource
    private RedisUtil redisUtil;


    @Override
    public List<Theme> listTheme() {

        if(redisUtil.exists("thKey")){
            Object o = redisUtil.lRange("thKey", 0, redisUtil.length("thKey")).get(0);
            return (List<Theme>) o;
        }else{
            List<Theme> list=themeDao.selectTheme();
            redisUtil.lPush("thKey",list);
            return list;
        }

    }
}
