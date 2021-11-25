package com.codegym.controller;

import com.codegym.model.EmailSettings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("home")
public class SettingsController {
    static  EmailSettings emailSettings = new EmailSettings("English",10,true,"Ok");
    @GetMapping("")
    public ModelAndView setupMail(){
       ModelAndView modelAndView = new ModelAndView("settings/index") ;
       modelAndView.addObject("emailSettings",emailSettings) ;
       return modelAndView ;
    }
    @PostMapping("/info")
    public  String showSettings(@ModelAttribute("emailSettings") EmailSettings emailSettings, Model model){
        model.addAttribute("languages", emailSettings.getLanguages());
        model.addAttribute("size", emailSettings.getSize()) ;
        model.addAttribute("spams_filter",emailSettings.isSpams_filter());
        model.addAttribute("signature",  emailSettings.getSignature()) ;
     return "settings/info";
    }
}
