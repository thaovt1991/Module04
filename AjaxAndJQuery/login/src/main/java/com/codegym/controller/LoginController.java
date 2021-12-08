package com.codegym.controller;

import com.codegym.model.User;
import com.sun.tracing.dtrace.Attributes;
import groovyjarjarpicocli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.ResourceBundle;

@Controller
public class LoginController {
    @Autowired
    private MessageSource messageSource ;

    @GetMapping("/login")
    public ModelAndView showLoginForm(@RequestParam(required = false,defaultValue = "vi") String lang) {
        ModelAndView modelAndView = new ModelAndView("/login");
        modelAndView.addObject("user", new User());
        String language = messageSource.getMessage("language" ,null,new Locale(lang));

//        ResourceBundle rb = ResourceBundle.getBundle("message",new Locale(lang));
//        String language= rb.getString("language") ;
        modelAndView.addObject("language",language) ;
        return modelAndView;
    }

    @PostMapping("/doLogin")
    public ModelAndView doLogin(@ModelAttribute User user) {
        if(user.getUsername().equals("admin") && user.getPassword().equals("123456")){
            ModelAndView modelAndView = new ModelAndView("/success");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
        return new ModelAndView("/error");
    }
}
