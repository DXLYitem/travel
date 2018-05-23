package com.example.travel.control;

import com.example.travel.biz.DetailService;
import com.example.travel.biz.ItemService;
import com.example.travel.entity.Detail;
import com.example.travel.entity.Item;
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
    @RequestMapping("ProductDetail")
    private String detailList(Model model, Integer detailId){
        Integer a=detailId;
        List<Detail>detailList=detailService.detailList(detailId);

        List<Item>itemList=itemService.findDetailId(detailId);
        if(itemList!=null){
            model.addAttribute("itemList",itemList);
        }
        if(detailList!=null){
            model.addAttribute("detailList",detailList);
        }
        return "/www.sparkletour.com/ProductDetail/39634";
    }
}

