package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransferController {
    @GetMapping("/convert")
    public String convert(@RequestParam int usd, Model model) {
        int vnd = usd * 22800;
        model.addAttribute("vnd", vnd);
        return "exchange/convert";
    }
    @GetMapping("/hello")
    public String hello() {
//        int vnd = usd * 22800;
//        model.addAttribute("vnd", vnd);
        return "exchange/hello";
    }
}

