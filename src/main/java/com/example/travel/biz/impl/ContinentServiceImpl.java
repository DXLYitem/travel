package com.example.travel.biz.impl;

import com.example.travel.biz.ContinentService;
import com.example.travel.dao.ContinentDao;
import com.example.travel.entity.Continent;
import com.example.travel.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)//事物处理
public class ContinentServiceImpl implements ContinentService {
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private ContinentDao continentDao;

    @Override
    public List<Continent> listContinent(Integer continentId) {
        String conKey="conKey"+continentId;
        //判断redis缓存里键为con集合是否存在
        if(redisUtil.exists(conKey)){
            Object o = redisUtil.lRange(conKey, 0, redisUtil.length(conKey)).get(0);
            return (List<Continent>) o;
        }else{
            //查询地域集合
            List<Continent> list=continentDao.selectContinent(continentId);
            //把键为conKey值为list集合缓存到redis
            redisUtil.lPush(conKey,list);
            return list;
        }
    }

    @Override
    public List<Continent> listContinentByholidayId(Integer holidayId) {
        List<Continent> list=continentDao.selectContinentByholidayId(holidayId);
        return list;
    }
}
