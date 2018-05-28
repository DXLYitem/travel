package com.example.travel.biz;

import com.example.travel.entity.Associator;

public interface AssociatorService {
    public int add(Associator associator);

    public Associator query(String phone);

    public int quwerCount(String phone);

    public int modify(String email, String phone, String name);
}
