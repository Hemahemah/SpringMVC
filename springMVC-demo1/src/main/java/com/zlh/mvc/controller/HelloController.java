package com.zlh.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {


   /**
    * 跳转路径设置
    *  "/" --> WEB-INF/templates/index.html
    * @return 返回跳转页面
    */
   @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
       return "target";
    }
}
