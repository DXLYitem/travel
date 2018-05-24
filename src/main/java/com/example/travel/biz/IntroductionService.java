package com.example.travel.biz;

import com.example.travel.entity.Introduction;

import java.util.List;

public interface IntroductionService {
    /**
     * 根据itemId查询
     * @param itemId
     * @return
     */
    List<Introduction> finddetailId(Integer detailId);
}
