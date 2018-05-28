package com.example.travel.control;

import com.example.travel.biz.*;
import com.example.travel.entity.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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
    @RequestMapping("ProductDetail")
    private String detailList(Model model, Integer detailId){
        Integer a=detailId;
        /**
         * 根据详细Id查询
         */
        List<Detail>detailList=detailService.detailList(detailId);
        /**
         * 根据项目Id查询
         */
        List<Item>itemList=itemService.findDetailId(detailId);
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

