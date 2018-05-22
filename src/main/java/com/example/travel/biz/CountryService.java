package com.example.travel.biz;

import com.example.travel.entity.Country;

import java.util.List;

public interface CountryService {

    public List<Country> listCountry(Integer continentId);
}
