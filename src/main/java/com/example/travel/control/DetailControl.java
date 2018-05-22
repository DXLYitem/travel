package com.example.travel.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailControl {
    @RequestMapping("ProductDetail")
    private String detailList(int detailId){
        int a=detailId;

        return "/www.sparkletour.com/ProductDetail/39634";
    }
}
