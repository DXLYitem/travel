package com.example.travel.dao;

import com.example.travel.entity.Detail;
import com.example.travel.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DetailDao {
    /**
     * 根据项目表Id查询详细信息
     * @param detailId
     * @return
     */
    List<Detail> selectDetail(@Param("detailId") Integer detailId);
}
