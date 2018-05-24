package com.example.travel.control;

import com.example.travel.biz.ContinentService;
import com.example.travel.biz.impl.AssociatorServiceImpl;
import com.example.travel.biz.impl.CustomizeServiceImpl;
import com.example.travel.biz.impl.HotelServiceImpl;
import com.example.travel.biz.impl.PreorderServiceImpl;
import com.example.travel.entity.*;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonaliseController {

    @Autowired
    private ContinentService continentService;
    @Autowired
    private HotelServiceImpl hotelServiceImpl;
    @Autowired
    private CustomizeServiceImpl customizeServiceImpl;
    @Autowired
    private PreorderServiceImpl preorderServiceImpl;
    @Autowired
    private AssociatorServiceImpl associatorServiceImpl;

    @RequestMapping("/Personalise")
    public String personalise(Model model){
        List<CangWei> cangWeis=new ArrayList<>();
        List<RoomStyle> roomstyle=new ArrayList<>();
        cangWeis.add(new CangWei(0,"选择舱位"));
        cangWeis.add(new CangWei(1,"头等舱"));
        cangWeis.add(new CangWei(2,"商务舱"));
        cangWeis.add(new CangWei(3,"经济舱"));
        roomstyle.add(new RoomStyle(0,"选择房间类型"));
        roomstyle.add(new RoomStyle(1,"高级套间"));
        roomstyle.add(new RoomStyle(1,"多套间"));
        roomstyle.add(new RoomStyle(1,"组合套间"));
        roomstyle.add(new RoomStyle(1,"双套间"));
        roomstyle.add(new RoomStyle(1,"套间"));
        roomstyle.add(new RoomStyle(1,"行政间"));
        roomstyle.add(new RoomStyle(1,"商务间"));
        roomstyle.add(new RoomStyle(1,"标准间"));
        roomstyle.add(new RoomStyle(1,"单人间"));
        model.addAttribute("area",continentService.listContinent());
        model.addAttribute("cang",cangWeis);
        model.addAttribute("roomstyle",roomstyle);
        return "www.sparkletour.com/Personalise";
    }

    /**
     * 根据目的地查询酒店
     * @param conid
     * @return
     */
    @ResponseBody
    @RequestMapping("hotel")
    public List<Hotel> hotelList(Integer conid){
        List<Hotel> li=hotelServiceImpl.listHotel(conid);
        return li;
    }

    /**
     * 直接提交
     * @param customize
     * @return
     */
    @RequestMapping("simpleSubmit")
    @ResponseBody
    public Integer simpleSubmit(Customize customize){
        /*if(customize.getFlightSpace()!=null && customize.getFlightSpace().equals("选择舱位")){
            customize.setFlightSpace(null);
        }
        if(customize.getHotel() !=null && customize.getHotel().equals("请选择")){
            customize.setHotel(null);
        }
        if(customize.getRoomType() !=null && customize.getRoomType().equals("选择房间类型")){
            customize.setRoomType(null);
        }
        int num=customizeServiceImpl.addCustomize(customize);
        return  num;*/
        return 0;
    }

    /**
     * 调转订单页面
     * @return
     */
    @RequestMapping("order")
    public String order(String phone,Model model){
        List<Customize> list=new ArrayList<>();
        if(phone!=null && phone !=""){
            list=customizeServiceImpl.listCustomize(phone);
            model.addAttribute("orderlsit",list);
            model.addAttribute("name",list.get(0).getContact());
        }
        return "www.sparkletour.com/member/order";
    }

    /**
     * 预约订制
     * @param preorder
     * @return
     */
    @RequestMapping("preorder")
    @ResponseBody
    public Integer preorder(Preorder preorder){
        Integer num=preorderServiceImpl.addPreorder(preorder);
        return num;
    }

    @RequestMapping("associator")
    public String associator(){
        return "www.sparkletour.com/member/index";
    }

    @RequestMapping("point")
    public String point(){
        return "www.sparkletour.com/member/point";
    }
}
