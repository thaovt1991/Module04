package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Deposit;
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
        modelAndView.addObject("deposits",new Deposit(id));
        modelAndView.addObject("customer",customer);
        return modelAndView ;
    }
    @PostMapping("/deposits")
    private ModelAndView saveDeposits(@ModelAttribute("deposits") Deposit deposit){
        Customer customer = customerService.findById(deposit.getIdOwner());
        long money_deposits = deposit.getAmount();
        boolean isMoney = false;
        if (money_deposits > 1000 && money_deposits <= 1000000000) {
            isMoney = true;
        }
        ModelAndView modelAndView = new ModelAndView("/customer/deposits");
        if(isMoney){
        depositsService.save(deposit);
        customer.setBalance(customer.getBalance()+ deposit.getAmount());
        customerService.save(customer);
            modelAndView.addObject("message", "Deposits successfully");
        }else {
            modelAndView.addObject("error","Deposits error !");
        }
        modelAndView.addObject("deposits", new Deposit(deposit.getIdOwner()));
        modelAndView.addObject("customer",customer);
        return modelAndView ;
    }
}
