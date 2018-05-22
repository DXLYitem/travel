package com.example.travel.biz.impl;

import com.example.travel.biz.PreorderService;
import com.example.travel.dao.PreorderDao;
import com.example.travel.entity.Preorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("preorderServiceImpl")
public class PreorderServiceImpl implements PreorderService {

    @Autowired
    private PreorderDao preorderDao;
    @Override
    public Integer addPreorder(Preorder preorder) {
        return preorderDao.insertPreorder(preorder);
    }
}
