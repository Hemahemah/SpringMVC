package com.zlh.mvc.controller;

import com.zlh.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){//形参位置的request表示当前请求
        HttpSession session = request.getSession();
        System.out.println(request.getParameter("username")+","+request.getParameter("password"));
    return "success";
}

    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "user_name" , required = false ) String username,//required代表是否必须传输value所对应的请求参数defaultValue = "user"//设置默认值
            String password, String[] hobby, //或者写成String hobby
            @RequestHeader(value = "Host",required = false,defaultValue = "8080") String host,
            @CookieValue("JSESSIONID") String JSESSIONID
            ){
        //请求参数出现多个同名的请求参数,可以在控制器方法的形参方法的形参位置设置字符串或字符串数组
        System.out.println("username:"+username+","+"password:"+password);
        for (String s : hobby) {
            System.out.println(s);
        }
        System.out.println("host:"+host);
        System.out.println("JSESSIONID:"+JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }


}
