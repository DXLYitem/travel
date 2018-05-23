package com.example.travel.control;

import com.example.travel.biz.*;
import com.example.travel.entity.Item;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ItemControl {
    @Resource
    private ItemService itemService;
   /* @Resource
    private ThemeService themeService;
    @Resource
    private HobbyService hobbyService;
    @Resource
    private StyleService styleService;
    @Resource
    private TravelService travelService;
    @Resource
    private TrafficService trafficService;*/
    @RequestMapping("ProductList")
    public String pList(@RequestParam(required=true,defaultValue="1") Integer page, Model model,
                        Integer themeId, Integer hobbyId, Integer travelId,
                        Integer trafficId, Integer styleId, Integer pn,String  startTime,Integer continentId) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        if(startTime!=null){
          date=sdf.parse(startTime);
       }

        //page从第几页开始，pagerSize每页显示3条数据
       // PageHelper.startPage(page,10);
        List<Item>itemList=itemService.itemsList(themeId, hobbyId, travelId, trafficId, styleId,date,continentId);
        PageInfo<Item> pager=new PageInfo<Item>(itemList);
        if(itemList!=null){
            //根据点击分页查询
            //model.addAttribute("pager",pager);
            model.addAttribute("ItemList",itemList);
        }
       return "/www.sparkletour.com/ProductList/94";
    }
}
