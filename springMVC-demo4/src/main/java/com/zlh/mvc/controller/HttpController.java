package com.zlh.mvc.controller;

import com.zlh.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class HttpController {

    @PostMapping("/testRequestBody")
    public String estRequestBody(@RequestBody String requestBody){//请求体
        System.out.println("requestBody:"+requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){//整个请求报文的信息
        System.out.println("请求头:"+requestEntity.getHeaders());
        System.out.println("请求体:"+requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponse(){
        return "success";//响应体
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){//处理JSON
        return new User(1001,"admin","123",12,"男");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println("username:"+username+",password:"+password);
        return "hello,axios";
    }

}
