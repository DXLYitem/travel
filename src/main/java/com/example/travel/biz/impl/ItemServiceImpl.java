package com.example.travel.biz.impl;

import com.example.travel.biz.ItemService;
import com.example.travel.dao.ItemDao;
import com.example.travel.entity.Country;
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
    public List<Item> listHobbyName(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId,
                                    Integer styleId, Date startTime, Integer continentId, Integer countryId) {
        String iKey=null;

        if(themeId!=null){
            iKey="iKey"+themeId;
        }
        if(hobbyId!=null){
            iKey="iKey"+hobbyId;
        }
        if(travelId!=null){
            iKey="iKey"+travelId;
        }
        if(trafficId!=null){
            iKey="iKey"+trafficId;
        }
        if(styleId!=null){
            iKey="iKey"+styleId;
        }
        if(startTime!=null){
            iKey="iKey"+startTime;
        }
        if(continentId!=null){
            iKey="iKey"+continentId;
        }
        if(countryId!=null){
            iKey="iKey"+countryId;
        }
        if(startTime!=null &&  continentId!=null){
            iKey="iKey"+startTime+continentId;
        }
        if(redisUtil.exists(iKey)){
            Object o = redisUtil.lRange(iKey, 0, redisUtil.length(iKey)).get(0);
            return (List<Item>) o;
        }else{
            List<Item> list=itemDao.selectHobbyName(themeId, hobbyId, travelId, trafficId, styleId ,startTime,continentId,countryId);
            redisUtil.lPush(iKey,list);
            return list;
        }
    }

    @Override
    public List<Item> listTravelName(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId,
                                     Date startTime,Integer continentId ,Integer countryId) {

        List<Item>items=itemDao.selectTravelName(themeId, hobbyId, travelId, trafficId, styleId ,startTime,continentId,countryId);
        return items;
    }

    @Override
    public List<Item> itemsList(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId, Date startTime,Integer continentId,Integer countryId) {
        List<Item>items=itemDao.selectPageItem(themeId, hobbyId, travelId, trafficId, styleId ,startTime,continentId,countryId);

        if(redisUtil.exists("item")){
            redisUtil.remove("item");
        }
        redisUtil.lPush("item",items);
        return items;
    }
    @Override
    public boolean itemCount(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId) {






        if (redisUtil.exists("itemCount")) {
            redisUtil.remove("itemCount");
        }
        int itemCount = itemDao.selectPageCount(themeId, hobbyId, travelId, trafficId, styleId);
        redisUtil.lPush("itemCount", itemCount);

        return itemCount>0;
    }
    @Override
    public List<Item> findDetailId(Integer detailId) {
        String iKey="iKey"+detailId;

        if(redisUtil.exists(iKey)){
            Object o = redisUtil.lRange(iKey, 0, redisUtil.length(iKey)).get(0);
            return (List<Item>) o;
        }else{
            List<Item> list=itemDao.selectDetailId(detailId);
            redisUtil.lPush(iKey,list);
            return list;
        }
     }
}
