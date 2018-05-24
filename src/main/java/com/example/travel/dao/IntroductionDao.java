package com.example.travel.dao;

import com.example.travel.entity.Introduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *介绍表Dao
 */
public interface IntroductionDao{
    /**
     * 根据itemId查询
     * @param itemId
     * @return
     */
   List<Introduction>selectIntrod(@Param("detailId") Integer detailId);
}
