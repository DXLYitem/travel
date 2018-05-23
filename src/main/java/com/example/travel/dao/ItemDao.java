package com.example.travel.dao;

import com.example.travel.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ItemDao {
    /**
     * 根据各个Id查询
     * @param themeId父级主题Id
     * @param hobbyId旅行偏好Id
     * @param travelId旅行主题Id
     * @param trafficId交通工具Id
     * @param styleId旅行方式Id
     * @param from从第几条开始
     * @param pageSize每页显示几条
     * @return
     */
    List<Item> selectPageItem(
            @Param("themeId") Integer themeId,
            @Param("hobbyId") Integer hobbyId,
            @Param("travelId") Integer travelId,
            @Param("trafficId") Integer trafficId,
            @Param("styleId") Integer styleId,
            @Param("startTime") Date startTime,
            @Param("continentId")Integer continentId
                         /* @Param("currentPage") Integer currentPage,
                          @Param("pageSize") Integer pageSize*/
    );
    /**
     * 根据各个Id统计记录条数
     * @param themeId父级主题Id
     * @param hobbyId旅行偏好Id
     * @param travelId旅行主题Id
     * @param trafficId交通工具Id
     * @param styleId旅行方式Id
     * @return
     */
    int selectPageCount(@Param("themeId") Integer themeId,
                        @Param("hobbyId") Integer hobbyId,
                        @Param("travelId") Integer travelId,
                        @Param("trafficId") Integer trafficId,
                        @Param("styleId") Integer styleId);
    List<Item>selectDetailId(@Param("detailId") Integer themeId);
}
