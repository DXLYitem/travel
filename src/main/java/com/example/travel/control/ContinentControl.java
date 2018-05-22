package com.example.travel.control;

import com.example.travel.biz.*;
import com.example.travel.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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

     @RequestMapping("/index")
     public  String selectContinent(Model model,Integer continentId){
         //地域
         List<Continent> list=continentService.listContinent(continentId);
         model.addAttribute("conList",list);
         //地区
         for(int i=0;i<list.size();i++){
           model.addAttribute("couList"+i,countryService.listCountry(list.get(i).getContinentId()));
         }

         //偏好
         model.addAttribute("h",hobbyService.listHobby(1));
         //主题
         model.addAttribute("t",travelService.listTravel(2));
         //交通工具
         model.addAttribute("c",trafficService.listTraffic(3));
         //旅行方式
         model.addAttribute("s",styleService.listStyle(4));
         //旅行主题
          model.addAttribute("themeList",themeService.listTheme());

        // System.out.println(11111);

        return "/www.sparkletour.com/index";
     }
}
