package com.example.travel.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 摄影控制层
 */
@Controller
public class PhotographyControl {
    @RequestMapping("photography")
    public String photography(){
        return "/www.sparkletour.com/nge/photography";
    }
}
