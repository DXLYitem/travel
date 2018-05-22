package com.example.travel.biz.impl;

import com.example.travel.biz.CustomizeService;
import com.example.travel.dao.CustomizeDao;
import com.example.travel.entity.Customize;
import com.example.travel.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("customizeServiceImpl")

public class CustomizeServiceImpl implements CustomizeService {

    @Autowired
    private CustomizeDao customizeDao;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public int addCustomize(Customize customize) {
        int num=customizeDao.submit(customize);
        //根据id和联系人生成缓存的键
        String id=queryId()+customize.getContact();
        redisUtil.set(id,customize);
        return num;
    }

    @Override
    public int queryId() {
        return customizeDao.selId();
    }
}
