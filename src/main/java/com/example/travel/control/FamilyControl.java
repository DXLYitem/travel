package com.example.travel.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 亲子优选控制层
 */
@Controller
public class FamilyControl {
    @RequestMapping("family")
    public String family(){
        return "/www.sparkletour.com/nge/family";
    }
}
