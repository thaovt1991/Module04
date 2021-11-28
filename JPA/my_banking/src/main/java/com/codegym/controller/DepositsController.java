package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Deposits;
import com.codegym.service.ICustomerService;
import com.codegym.service.IDepositsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepositsController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IDepositsService depositsService;

    @GetMapping("/deposits/{id}")
    private ModelAndView viewDeposits(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/customer/deposits");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("deposits",new Deposits(id));
        modelAndView.addObject("customer",customer);
        return modelAndView ;
    }
    @PostMapping("/deposits")
    private ModelAndView saveDeposits(@ModelAttribute("deposits") Deposits deposits){
        depositsService.save(deposits);
        ModelAndView modelAndView = new ModelAndView("/customer/deposits");
        Customer customer = customerService.findById(deposits.getIdOwner());
        customer.setBalance(customer.getBalance()+deposits.getAmount());
        customerService.save(customer);
        modelAndView.addObject("deposits", new Deposits(deposits.getIdOwner()));
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("message", "Deposits successfully");
        return modelAndView ;
    }
}
