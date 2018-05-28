package com.example.travel.biz;

import com.example.travel.entity.Associator;

public interface AssociatorService {
    public int add(Associator associator);

    public Associator query(String phone);
}
