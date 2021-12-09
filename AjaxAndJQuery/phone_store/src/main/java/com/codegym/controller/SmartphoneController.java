package com.codegym.controller;

import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/smartphones")
public class SmartphoneController {

    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping("/list")
    public String getList(Model model) {
        model.addAttribute("smartphones", smartphoneService.findAll());
//        ModelAndView modelAndView = new ModelAndView("/phones/list");
//        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return "/phones/list";
    }
}
