package com.example.travel.biz.impl;

import com.example.travel.biz.StyleService;
import com.example.travel.dao.StyleDao;
import com.example.travel.entity.Style;
import com.example.travel.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StyleServiceImpl implements StyleService {
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private StyleDao styleDao;


    @Override
    public List<Style> listStyle(Integer themeId) {

        String styKey="styKey"+themeId;
        if(redisUtil.exists(styKey)){
            Object o = redisUtil.lRange(styKey, 0, redisUtil.length(styKey)).get(0);
            return (List<Style>) o;
        }else{
            List<Style> list=styleDao.selectStyle(themeId);
            redisUtil.lPush(styKey,list);
            return list;
        }
    }
}
