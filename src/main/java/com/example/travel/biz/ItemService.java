package com.example.travel.biz;

import com.example.travel.entity.Item;

import java.util.Date;
import java.util.List;

/**
 * 查询旅游项目表所有数据
 */
public interface ItemService {
    List<Item>itemsList(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId,
                        Date startTime, Integer continentId, Integer countryId);

   boolean itemCount(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId);

    /**
     * 根据详细Id查询
     * @param detailId
     * @return
     */
    List<Item>findDetailId(Integer detailId);

    List<Item> listTravelName(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId,
                              Date startTime, Integer continentId, Integer countryId);

    List<Item> listHobbyName(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId,
                             Date startTime, Integer continentId, Integer countryId);

}
