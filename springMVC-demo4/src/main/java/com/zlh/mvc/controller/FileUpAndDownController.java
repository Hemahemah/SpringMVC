package com.zlh.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileUpAndDownController {

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/img1.png");
        System.out.println(realPath);
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];//available():该文件的所有字节数
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=img1.png");//attachment:以附件的形式下载
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp( MultipartFile photo,HttpSession session) throws IOException{
        System.out.println(photo.getName());
        System.out.println(photo.getOriginalFilename());//获取上传文件名
        String filename = photo.getOriginalFilename();
        String suffixName = filename.substring(filename.lastIndexOf(".")); //获取上传文件后缀名
        String uuid = UUID.randomUUID().toString();//将UUID作为文件名
        filename = uuid+suffixName;//将UUID与后缀名拼接
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("photo");//获取photo目录的路径
        File file = new File(realPath);
        if (!file.exists()){//判断对应路径是否存在
            file.mkdir();//创建目录
        }
        String finalPath = realPath + File.separator + filename;//File.separator:分隔符
        photo.transferTo(new File(finalPath));//文件上传
        return "success";
    }

}
