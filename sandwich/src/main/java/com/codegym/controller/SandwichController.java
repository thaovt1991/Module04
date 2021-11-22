package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @RequestMapping("/")
    public String loadIndex() {
        return "index";
    }

    @GetMapping("/save")
    public String save( @RequestParam("condiment") String[] condiments, Model model) {
        model.addAttribute("condiments", condiments);
        return "save";
    }
}

