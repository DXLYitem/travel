package com.example.travel.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PhotographyControl {
    @RequestMapping("photography")
    public String photography(){
        return "/www.sparkletour.com/nge/photography";
    }
}
