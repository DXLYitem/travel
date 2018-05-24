package com.example.travel.biz.impl;

import com.example.travel.biz.IntroductionService;
import com.example.travel.dao.DetailDao;
import com.example.travel.dao.IntroductionDao;
import com.example.travel.entity.Detail;
import com.example.travel.entity.Introduction;
import com.example.travel.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class IntroductionServiceImpl implements IntroductionService{
    @Resource
    private IntroductionDao introductionDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public List<Introduction> finddetailId(Integer detailId) {

        String Key = "key" + detailId;
        if (redisUtil.exists(Key)) {
            Object deId = redisUtil.lRange(Key, 0, redisUtil.length(Key)).get(0);
            return (List<Introduction>) deId;
        } else {
            List<Introduction> introdList = introductionDao.selectIntrod(detailId);
            redisUtil.lPush("introdList", introdList);
            return introdList;
        }
    }
}
