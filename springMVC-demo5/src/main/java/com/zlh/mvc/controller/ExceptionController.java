package com.zlh.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public String testException(Exception e, Model model){
        model.addAttribute("ex",e);
        return "error";
    }
}
