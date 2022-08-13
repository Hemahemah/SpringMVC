package com.zlh.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {


    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }

}
