package com.example.travel.control;

import com.example.travel.biz.*;
import com.example.travel.entity.Continent;
import com.example.travel.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ItemControl {
    @Resource
    private ItemService itemService;
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

    @RequestMapping("ProductList")
    public String pList(@RequestParam(required=true,defaultValue="1") Integer page, Model model,
                        Integer themeId, Integer hobbyId, Integer travelId,
                        Integer trafficId, Integer styleId, Integer pn,String  startTime,Integer continentId,Integer countryId) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        if(startTime!=null){
            date=new Date();
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
        List<Item>itemList=itemService.itemsList(themeId, hobbyId, travelId, trafficId, styleId,date,continentId,countryId);
        List<String> strList=new ArrayList<String>();
         for(int i=0;i<itemList.size();i++){
             String[] arr = itemList.get(i).getTitle().split(" ");
             strList.add(arr[0]);
         }
        //查询旅行主题
        List<Item> travelList1=itemService.listTravelName(themeId, hobbyId, travelId, trafficId, styleId,date,continentId,countryId);
         List<Item> travelList=new ArrayList<>();
         for(Item i:travelList1){
             if(i!=null){
                 travelList.add(i);
             }
         }
        //查询旅行偏好
        List<Item> hList1=itemService.listHobbyName(themeId, hobbyId, travelId, trafficId, styleId,date,continentId,countryId);
        List<Item> hList=new ArrayList<>();
        for(Item i:hList1){
            if(i!=null){
                hList.add(i);
            }
        }

       // PageInfo<Item> pager=new PageInfo<Item>(itemList);
        if(itemList.size()>0 && strList.size()>0 && travelList.size()>0 && hList.size()>0){
            //根据点击分页查询
            //model.addAttribute("pager",pager);
            model.addAttribute("ItemList",itemList);
            model.addAttribute("strList",strList);
            model.addAttribute("travelList",travelList);
            model.addAttribute("hList",hList);

          //  model.addAttribute("arrExplain",explain);
        }
       return "/www.sparkletour.com/ProductList/94";
    }

    @RequestMapping("aaa")
    @ResponseBody
    public String show(HttpServletRequest cc){
        String [] a=cc.getParameterValues("bb");

        return null;
    }

/*
    @RequestMapping("travelAjax")
    @ResponseBody
    public List<Item> travelById(HttpServletRequest travelId){
        String[] tId = travelId.getParameterValues("travelId");

        Integer[] ia=new Integer [tId.length];
        for(int i=0;i<tId.length;i++) {
            ia[i] = Integer.parseInt(tId[i]);
        }
        List<Item> itemList=itemService.ListTravelIdArray(ia);
        return itemList;
    }


    @RequestMapping("hobbyAjax")
    @ResponseBody
    public List<Item> hobbyById(HttpServletRequest hobbyId){
        String[] tId = hobbyId.getParameterValues("hobbyId");

        Integer[] ia=new Integer [tId.length];
        for(int i=0;i<tId.length;i++) {
            ia[i] = Integer.parseInt(tId[i]);
        }
        List<Item> itemList=itemService.ListHobbyIdArray(ia);
        return itemList;
    }
*/

    @RequestMapping("hobbyAjax")
    @ResponseBody
    public List<Item> hobbyByIdAndTravelId(HttpServletRequest hobbyId){
        String[] hId = hobbyId.getParameterValues("hobbyId");
        String[] tId = hobbyId.getParameterValues("travelId");
        Integer[] ia={};
        Integer[] ib={};
        if(hId!=null&&hId.length>0){
            ia=new Integer [hId.length];
            for(int i=0;i<hId.length;i++) {
                ia[i] = Integer.parseInt(hId[i]);
            }
        }
        if(tId!=null&&tId.length>0){
            ib=new Integer [tId.length];
            for(int i=0;i<tId.length;i++) {
                ib[i] = Integer.parseInt(tId[i]);
            }
        }

        List<Item> itemList=itemService.listHobbyIdAndTravelIdArray(ia,ib);

        return itemList;
    }
}
