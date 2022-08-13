package com.zlh.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";//没有前缀后缀则被Thymeleaf解析
    }

    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";//转发视图
    }


    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";//重定向视图
    }

}
