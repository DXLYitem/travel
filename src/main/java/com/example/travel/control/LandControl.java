package com.example.travel.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 世界控制层
 */
@Controller
public class LandControl {
    @RequestMapping("land")
    public String lang(){
        return "/www.sparkletour.com/nge/land";
    }
}
