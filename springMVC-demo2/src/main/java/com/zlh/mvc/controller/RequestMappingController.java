package com.zlh.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/hello")
@Controller
public class RequestMappingController {

    @RequestMapping(
            value = {"/testRequestMapping","/test"},//先匹配路径(匹配一个)
            method = {RequestMethod.GET,RequestMethod.POST},//枚举,不配置method默认支持所有方法(匹配一个)
            params = {"username",//请求参数必须携带username,!username即请求参数不能携带username
                    "password!=123456"
            }//(匹配所有)
    )
    public String success(){
        return "success";
    }


    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }

    @PutMapping("/testPutMapping")
    public String testPutMapping(){
        return "success";
    }

    @RequestMapping(
            value = "/testHeaders",
            headers = {"Host=localhost:8080"}
    )
    public String testHeadersMapping(){
        return "success";

    }

   //@RequestMapping("/a?a/testAnt")//?:任意单个字符
   //@RequestMapping("/a*a/testAnt")//*:任意一个或多个字符
   @RequestMapping("/**/testAnt")//*:任意一层或多层目录
   public String testAnt(){
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id") int id,@PathVariable("username") String username){//获取请求路径的参数(注解修饰形参)
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }

}
