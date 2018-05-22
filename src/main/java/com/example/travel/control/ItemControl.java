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
                        Integer trafficId, Integer styleId, Integer pn){
        //page从第几页开始，pagerSize每页显示3条数据
        PageHelper.startPage(page,10);
        List<Item>itemList=itemService.itemsList(themeId, hobbyId, travelId, trafficId, styleId);
        PageInfo<Item> pager=new PageInfo<Item>(itemList);
        if(itemList!=null){
            //根据点击分页查询
            model.addAttribute("pager",pager);
            model.addAttribute("ItemList",itemList);
        }
     /*   model.addAttribute("Theme",themeService.themeList());
        model.addAttribute("Hobby",hobbyService.hobbyList());
        model.addAttribute("Style",styleService.styleList());
        model.addAttribute("Travel",travelService.travelList());
        model.addAttribute("Traffic",trafficService.trafficList());*/
       return "/www.sparkletour.com/ProductList/94";
    }
}
