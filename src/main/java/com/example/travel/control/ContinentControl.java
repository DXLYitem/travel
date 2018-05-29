package com.example.travel.control;

import com.example.travel.biz.*;
import com.example.travel.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContinentControl {

    @Resource
    private ContinentService continentService;
    @Resource
    private CountryService countryService;
    @Resource
    private ThemeService themeService;
    @Resource
    private HobbyService hobbyService;
    @Resource
    private TravelService travelService;
    @Resource
    private TrafficService trafficService;
    @Resource
    private StyleService styleService;
    @Resource
    private HolidayService holidayService;
    @Resource
    private BrandService brandService;

     @RequestMapping("/index")
     public  String selectContinent(Model model, HttpSession session){
         //地域
         List<Continent> list=continentService.listContinent();
         session.setAttribute("conList",list);

         //地区
         for(int i=0;i<list.size();i++){
             session.setAttribute("couList"+i,countryService.listCountry(list.get(i).getContinentId()));
         }

        //偏好
         session.setAttribute("h",hobbyService.listHobby(1));
        //主题
         session.setAttribute("t",travelService.listTravel(2));
        //交通工具
         session.setAttribute("c",trafficService.listTraffic(3));
        //旅行方式
         session.setAttribute("s",styleService.listStyle(4));
        //旅行主题
         session.setAttribute("themeList",themeService.listTheme());
        //度假套餐
         session.setAttribute("holidayList", holidayService.listHoliday());
        //酒店品牌
         session.setAttribute("b",  brandService.listBrand(1));

         session.setAttribute("continent",continentService.listContinentByholidayId(2));

        return "/www.sparkletour.com/index";
     }
}
