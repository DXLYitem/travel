package com.example.travel.biz.impl;

import com.example.travel.biz.DetailService;
import com.example.travel.dao.DetailDao;
import com.example.travel.dao.ItemDao;
import com.example.travel.entity.Detail;
import com.example.travel.entity.Item;
import com.example.travel.util.RedisUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.Key;
import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)//事物处理
public class DetailServiceImpl implements DetailService{
    @Resource
    private DetailDao detailDao;
    @Resource
    private RedisUtil redisUtil;
    @Override
    public List<Detail> detailList(Integer detailId){
      String key="Key"+detailId;
      if(redisUtil.exists(key)){
        Object deId=redisUtil.lRange(key,0,redisUtil.length(key)).get(0);
        return (List<Detail>)deId;
      }
        List<Detail>detailList=detailDao.selectDetail(detailId);
        return detailList;
    }
}
