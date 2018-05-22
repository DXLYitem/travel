package com.example.travel.biz;

import com.example.travel.entity.Style;

import java.util.List;

public interface StyleService {
    public List<Style> listStyle(Integer themeId);
}
