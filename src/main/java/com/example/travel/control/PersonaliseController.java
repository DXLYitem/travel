package com.example.travel.control;

import com.example.travel.biz.impl.*;
import com.example.travel.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class PersonaliseController {

    @Autowired
    private ContinentServiceImpl continentServiceImpl;
    @Autowired
    private HotelServiceImpl hotelServiceImpl;
    @Autowired
    private CustomizeServiceImpl customizeServiceImpl;
    @Autowired
    private PreorderServiceImpl preorderServiceImpl;
    @Autowired
    private AssociatorServiceImpl associatorServiceImpl;
    @Autowired
    private OrderServiceImpl orderServiceImpl;

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
        model.addAttribute("area",continentServiceImpl.listContinent());
        model.addAttribute("cang",cangWeis);
        model.addAttribute("roomstyle",roomstyle);
        return "www.sparkletour.com/Personalise";
    }

    /**
     * 跳转会员信息页面
     * @param phone
     * @return
     */
    @RequestMapping("associator")
    public String member(String phone,Model model){
        model.addAttribute("associator",associatorServiceImpl.query(phone));
        return "www.sparkletour.com/member/associator";
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
        if(customize.getFlightSpace()!=null && customize.getFlightSpace().equals("选择舱位")){
            customize.setFlightSpace(null);
        }
        if(customize.getHotel() !=null && customize.getHotel().equals("请选择")){
            customize.setHotel(null);
        }
        if(customize.getRoomType() !=null && customize.getRoomType().equals("选择房间类型")){
            customize.setRoomType(null);
        }
        Order order=new Order();
        Random in=new Random();
        int ordernum=in.nextInt();
        Date ordertime=new Date();
        int date=(int) new Date().getTime();
        order.setOrderNum(ordernum+"");
        order.setStatus("未消费");
        order.setPrice(0.0);
        int num=customizeServiceImpl.addCustomize(customize,order);
        return  num;
        /*return 0;*/
    }

    /**
     * 调转订单页面
     * @return
     */
    @RequestMapping("order")
    public String order(String phone,String num,Model model) throws ParseException {
        List<Order> list=new ArrayList<>();
        if(phone!=null && phone !=""){
            Integer num1=Integer.parseInt(num);
            list=orderServiceImpl.orderList(phone,num1);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
            for(int i=0;i<list.size();i++){
                String a=sdf.format(list.get(i).getOrderTime());
                list.get(i).setTime(a);
            }
            model.addAttribute("orderlsit",list);
            if(list.size()>0){
                model.addAttribute("name",list.get(0).getCustomize().getContact());
            }
        }
        return "www.sparkletour.com/member/order";
    }

    @RequestMapping("orderMore")
    @ResponseBody
    public List<Order> moreOrder(String phone){
        List<Order> list=orderServiceImpl.orderList(phone,null);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        for(int i=0;i<list.size();i++){
            String a=sdf.format(list.get(i).getOrderTime());
            list.get(i).setTime(a);
        }
        return list;
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
    /**
     * 跳转积分页面
     * @param phone
     * @return
     */
    @RequestMapping("point")
    public String point(String phone){
        return "www.sparkletour.com/member/point";
    }

    /**
     * 根据id查询订单信息
     * @param id
     * @return
     */
    @RequestMapping("orderShow")
    @ResponseBody
    public Customize selCustomize(String id){
        Customize c=new Customize();
        if (id != null && id != "") {
            Integer customizeid=Integer.parseInt(id);
            c=customizeServiceImpl.listCustomize(customizeid);
            if(c.getStartDate()!=null && c.getStartDate()!=null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                c.setStartDateString(sdf.format(c.getStartDate()));
                c.setEndDateString(sdf.format(c.getStartDate()));
            }
        }
        return c;
    }

    /**
     * 根据电话修改email
     * @param email
     * @param phone
     * @return
     */
    @RequestMapping("modifyEmail")
    @ResponseBody
    public int modifyEmail(String email,String phone,String name){
        return associatorServiceImpl.modify(email,phone,name);
    }
}
