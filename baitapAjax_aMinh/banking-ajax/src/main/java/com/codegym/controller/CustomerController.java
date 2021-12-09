package com.codegym.controller;

import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService ;

    @GetMapping()
    private ModelAndView showAllCustomers(){
        ModelAndView modelAndView = new ModelAndView("/customer/list") ;
        return modelAndView ;
    }
}
