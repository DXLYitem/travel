package com.example.travel.biz.impl;

import com.example.travel.biz.AssociatorService;
import com.example.travel.dao.AssociatorDao;
import com.example.travel.entity.Associator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("associatorServiceImpl")
public class AssociatorServiceImpl implements AssociatorService {

    @Autowired
    private AssociatorDao associatorDao;

    @Override
    public int add(Associator associator) {
        return associatorDao.insert(associator);
    }
}
