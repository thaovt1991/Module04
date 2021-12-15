package com.codegym.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

    @GetMapping("/home")
    public ModelAndView showPage(){
        ModelAndView modelAndView = new ModelAndView("/index") ;
        return  modelAndView;
    }

}
