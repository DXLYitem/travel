package com.example.travel.biz.impl;

import com.example.travel.biz.ItemService;
import com.example.travel.dao.ItemDao;
import com.example.travel.entity.Item;
import com.example.travel.util.RedisUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)//事物处理
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemDao itemDao;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Item> itemsList(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId) {
        Item item=new Item();
        //父级主题Id
        if(themeId!=null){
            item.setItemId(themeId);
        }
        //旅行偏好Id
        if(hobbyId!=null){
            item.setHobbyId(hobbyId);
        }
        //旅行主题Id
        if(travelId!=null){
            item.setTravelId(travelId);
        }
        //交通工具Id
        if(trafficId!=null){
            item.setTravelId(trafficId);
        }
        //旅行方式Id
        if(styleId!=null){
            item.setStyleId(styleId);
        }
        List<Item>items=itemDao.selectPageItem(themeId, hobbyId, travelId, trafficId, styleId);

        if(redisUtil.exists("item")){
            redisUtil.remove("item");
        }
        redisUtil.lPush("item",items);
        return items;
    }

    @Override
    public boolean itemCount(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId) {
        Item item = new Item();
        //父级主题Id
        if (themeId != null) {
            item.setItemId(themeId);
        }
        //旅行偏好Id
        if (hobbyId != null) {
            item.setHobbyId(hobbyId);
        }
        //旅行主题Id
        if (travelId != null) {
            item.setTravelId(travelId);
        }
        //交通工具Id
        if (trafficId != null) {
            item.setTravelId(trafficId);
        }
        //旅行方式Id
        if (styleId != null) {
            item.setStyleId(styleId);
        }
        if (redisUtil.exists("itemCount")) {
            redisUtil.remove("itemCount");
        }
        int itemCount = itemDao.selectPageCount(themeId, hobbyId, travelId, trafficId, styleId);
        redisUtil.lPush("itemCount", itemCount);

        return itemCount>0;
    }
}
