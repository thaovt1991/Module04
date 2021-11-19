package com.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TransferController {
    @GetMapping("/convert")
    public String convert(@RequestParam int usd, Model model) {
        int vnd = usd * 22800;
        model.addAttribute("vnd", vnd);
        return "convert";
    }
}
