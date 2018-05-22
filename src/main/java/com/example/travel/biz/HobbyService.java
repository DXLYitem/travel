package com.example.travel.biz;

import com.example.travel.entity.Hobby;

import java.util.List;

public interface HobbyService {

    public List<Hobby> listHobby(Integer themeId);
}
