package com.example.travel.biz.impl;

import com.example.travel.biz.ItemService;
import com.example.travel.dao.ItemDao;
import com.example.travel.entity.Country;
import com.example.travel.entity.Item;
import com.example.travel.util.RedisUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List<Item> listHobbyIdAndTravelIdArray(Integer[] hobbyId, Integer[] travelId) {
        List<Item> itemArray=itemDao.selectHobbyIdAndTravelIdArray(hobbyId,travelId);
        return itemArray;
    }

    @Override
    public List<Item> ListHobbyIdArray(Integer[] hobbyId) {
        List<Item> ItemArray=itemDao.selectHobbyIdArray(hobbyId);
        return ItemArray;
    }

    @Override
    public List<Item> ListTravelIdArray(Integer[] travelId) {
        List<Item> ItemArray=itemDao.selectTravelIdArray(travelId);

        return ItemArray;
    }


    @Override
    public List<Item> listHobbyName(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId,
                                    Integer styleId, Date startTime, Integer continentId, Integer countryId) {
        String iKey=null;

        if(themeId!=null){
            iKey="iKeythemeId"+themeId;
        }
        if(hobbyId!=null){
            iKey="iKeyhobbyId"+hobbyId;
        }
        if(travelId!=null){
            iKey="iKeytravelId"+travelId;
        }
        if(trafficId!=null){
            iKey="iKeyrafficId"+trafficId;
        }
        if(styleId!=null){
            iKey="iKeystyleId"+styleId;
        }
        if(startTime!=null){
            iKey="iKeystartTime"+startTime;
        }
        if(continentId!=null){
            iKey="iKeycontinentId"+continentId;
        }
        if(countryId!=null){
            iKey="iKeycountryId"+countryId;
        }
        if(startTime!=null &&  continentId!=null){
            iKey="iKeystartTimecontinentId"+startTime+continentId;
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

        String iKey=null;

        if(themeId!=null){
            iKey="iteKeythemeId"+themeId;
        }
        if(hobbyId!=null){
            iKey="iteKeyhobbyId"+hobbyId;
        }
        if(travelId!=null){
            iKey="iteKeytravelId"+travelId;
        }
        if(trafficId!=null){
            iKey="itemKeyrafficId"+trafficId;
        }
        if(styleId!=null){
            iKey="iteKeystyleId"+styleId;
        }
        if(startTime!=null){
            iKey="iteKeystartTime"+startTime;
        }
        if(continentId!=null){
            iKey="iteKeycontinentId"+continentId;
        }
        if(countryId!=null){
            iKey="iteKeycountryId"+countryId;
        }
        if(startTime!=null &&  continentId!=null){
            iKey="iteKeystartTimecontinentId"+startTime+continentId;
        }
        if(redisUtil.exists(iKey)){
            Object o = redisUtil.lRange(iKey, 0, redisUtil.length(iKey)).get(0);
            return (List<Item>) o;
        }else{
            List<Item>items=itemDao.selectTravelName(themeId, hobbyId, travelId, trafficId, styleId ,startTime,continentId,countryId);
            redisUtil.lPush(iKey,items);
            return items;
        }

    }

    @Override
    public List<Item> itemsList(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId,
                                Date startTime,Integer continentId,Integer countryId) {

        String iKey=null;

        if(themeId!=null){
            iKey="itemKeythemeId"+themeId;
        }
        if(hobbyId!=null){
            iKey="itemKeyhobbyId"+hobbyId;
        }
        if(travelId!=null){
            iKey="itemKeytravelId"+travelId;
        }
        if(trafficId!=null){
            iKey="itemKeyrafficId"+trafficId;
        }
        if(styleId!=null){
            iKey="itemKeystyleId"+styleId;
        }
        if(startTime!=null){
            iKey="itemKeystartTime"+startTime;
        }
        if(continentId!=null){
            iKey="itemKeycontinentId"+continentId;
        }
        if(countryId!=null){
            iKey="itemKeycountryId"+countryId;
        }
        if(startTime!=null &&  continentId!=null){
            iKey="itemKeystartTimecontinentId"+startTime+continentId;
        }
        List<Item> items=new ArrayList<Item>();
        redisUtil.remove(iKey);
        if(redisUtil.exists(iKey)){
            items = (List<Item>)redisUtil.lRange(iKey, 0, redisUtil.length(iKey)).get(0);
        }else{
            items=itemDao.selectPageItem(themeId, hobbyId, travelId, trafficId, styleId ,startTime,continentId,countryId);
            redisUtil.lPush(iKey,items);
        }
        return  items;
    }
    @Override
    public boolean itemCount(Integer themeId, Integer hobbyId, Integer travelId, Integer trafficId, Integer styleId) {
      int itemCount = itemDao.selectPageCount(themeId, hobbyId, travelId, trafficId, styleId);
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
