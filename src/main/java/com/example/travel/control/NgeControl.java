package com.example.travel.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 国家地理控制层
 */
@Controller
public class NgeControl {
    @RequestMapping("nge")
    public String nge(){
        return "/www.sparkletour.com/nge";
    }
}
