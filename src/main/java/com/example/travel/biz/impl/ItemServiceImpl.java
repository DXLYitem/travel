package com.example.travel.biz.impl;

import com.example.travel.biz.ItemService;
import com.example.travel.dao.ItemDao;
import com.example.travel.entity.Item;
import com.example.travel.util.RedisUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)//事物处理
public class ItemServiceImpl implements ItemService{
    @Resource
    private ItemDao itemDao;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Item> itemsList(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId, Date startTime,Integer continentId) {
        List<Item>items=itemDao.selectPageItem(themeId, hobbyId, travelId, trafficId, styleId ,startTime,continentId);

        if(redisUtil.exists("item")){
            redisUtil.remove("item");
        }
        redisUtil.lPush("item",items);
        return items;
    }
    @Override
    public boolean itemCount(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId) {
        int itemCount = itemDao.selectPageCount(themeId, hobbyId, travelId, trafficId, styleId);
        redisUtil.lPush("itemCount", itemCount);

        return itemCount>0;
    }
    @Override
    public List<Item> findDetailId(Integer detailId) {
        Item item=new Item();
        if(detailId!=null){
            item.setStyleId(detailId);
        }
        List<Item>findDetailId=itemDao.selectDetailId(detailId);

        if(redisUtil.exists("findDetailId")){
            redisUtil.remove("findDetailId");
        }
        redisUtil.lPush("findDetailId",findDetailId);

        return findDetailId;
    }
}
