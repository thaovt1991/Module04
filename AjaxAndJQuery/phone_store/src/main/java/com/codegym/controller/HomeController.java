package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.ISmartphoneService;
import groovyjarjarpicocli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

//@Controller
//public class HomeController {
//
//    @GetMapping("/")
//    public String showIndex() {
//        return "/index";
//    }
//}
@Controller
@RequestMapping("")
public class HomeController {


    @GetMapping
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }

//    @GetMapping("/list")
//    public ModelAndView getAllSmartphonePage() {
//        ModelAndView modelAndView = new ModelAndView("/phones/list");
//        modelAndView.addObject("smartphones", smartphoneService.findAll());
//        return modelAndView;
//    }






//    @PutMapping("/{id}")
//    public ResponseEntity<Smartphone> updateCustomer(@PathVariable Long id, @RequestBody Smartphone smartphone) {
//        Optional<Smartphone> customerOptional = smartphoneService.findById(id);
//        if (!customerOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        smartphone.setId(customerOptional.get().getId());
//        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.OK);
//    }

}