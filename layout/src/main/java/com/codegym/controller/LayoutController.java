package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout")
public class LayoutController {

    @GetMapping()
    public String show(){
        return "/index" ;
    }
    @GetMapping("/layout#")
    public String show2(){
        return "/index" ;
    }
}
