package com.example.travel.control;

import com.example.travel.biz.*;
import com.example.travel.entity.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DetailControl {
    @Resource
    private DetailService detailService;
    @Resource
    private ItemService itemService;
    @Resource
    private IntroductionService introductionService;
    @Resource
    private ScheduleService scheduleService;
    @Resource
    private HotelService hotelService;
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
    @RequestMapping("ProductDetail")
    private String detailList(@RequestParam(required=true,defaultValue="1") Integer page, Model model, Integer detailId,
                              Integer themeId, Integer hobbyId, Integer travelId,
                              Integer trafficId, Integer styleId, Integer pn,
                              String  startTime,Integer continentId,Integer countryId,Integer brandId,Integer holidayId)throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        if(startTime!=null){
            date=sdf.parse(startTime);
        }
        //地域
        List<Continent> list=continentService.listContinent();
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
        //page从第几页开始，pagerSize每页显示3条数据
        // PageHelper.startPage(page,10);
        List<Item>itemList=itemService.itemsList(themeId, hobbyId, travelId, trafficId, styleId,date,continentId,countryId,detailId,brandId,holidayId);
        List<String> strList=new ArrayList<String>();
        for(int i=0;i<itemList.size();i++){
            String[] arr = itemList.get(i).getTitle().split(" ");
            strList.add(arr[0]);
        }
        //查询旅行主题
        List<Item> travelList=itemService.listTravelName(themeId, hobbyId, travelId, trafficId, styleId,date,continentId,countryId,detailId,brandId,holidayId);
        //查询旅行偏好
        List<Item> hList=itemService.listHobbyName(themeId, hobbyId, travelId, trafficId, styleId,date,continentId,countryId,detailId,brandId,holidayId);

        // PageInfo<Item> pager=new PageInfo<Item>(itemList);
        if(itemList.size()>0 && strList.size()>0 && travelList.size()>0 ){
            //根据点击分页查询
            //model.addAttribute("pager",pager);
            model.addAttribute("ItemList",itemList);
            model.addAttribute("strList",strList);
            model.addAttribute("travelList",travelList);
            model.addAttribute("hList",hList);
            //  model.addAttribute("arrExplain",explain);
        }
        //酒店品牌
        model.addAttribute("b", brandService.listBrand(1));
         //查询地区表
        model.addAttribute("continent",continentService.listContinentByholidayId(2));
        //度假套餐
        model.addAttribute("holidayList", holidayService.listHoliday());
        /**
         * 根据详细Id查询
         */
        List<Detail>detailList=detailService.detailList(detailId);
        /**
         * 根据介绍Id查询
         */
        List<Introduction>introList=introductionService.finddetailId(detailId);
        if(introList!=null){
            model.addAttribute("introList",introList);
        }
        if(itemList!=null){
            model.addAttribute("itemList",itemList);
        }
        if(detailList!=null){
            model.addAttribute("detailList",detailList);
        }

        /**
         * 根据项目id查询行程表
         */
        Integer itemid=null;
        if(detailList.size()>0){
            itemid=detailList.get(0).getItemId();
        }
        List<Schedule>schedList=scheduleService.findByitemId(itemid);
        model.addAttribute("schedList",schedList);
        /**
         * 根据行程表中的酒店Id查询酒店信息
         */
        Integer hotelId=null;
        if(schedList.size()>0){
            hotelId=schedList.get(0).getHotelId();
        }
        List<Hotel>hotels=hotelService.findByhotelId(hotelId);
        model.addAttribute("hotels",hotels);

        return "/www.sparkletour.com/ProductDetail/39634";
    }
}

