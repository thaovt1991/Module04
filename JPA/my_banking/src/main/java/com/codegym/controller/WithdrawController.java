package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Deposits;
import com.codegym.model.Withdraw;
import com.codegym.service.ICustomerService;
import com.codegym.service.IWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WithdrawController {
    @Autowired
    private IWithdrawService withdrawService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/withdraw/{id}")
    private ModelAndView viewDeposits(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/customer/withdraw");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("withdraw",new Withdraw(id));
        modelAndView.addObject("customer",customer);
        return modelAndView ;
    }
    @PostMapping("/withdraw")
    private ModelAndView saveDeposits(@ModelAttribute("withdraw") Withdraw withdraw){
        withdrawService.save(withdraw);
        ModelAndView modelAndView = new ModelAndView("/customer/withdraw");
        Customer customer = customerService.findById(withdraw.getIdOwner());
        customer.setBalance(customer.getBalance()-withdraw.getAmount());
        customerService.save(customer);
        modelAndView.addObject("withdraw", new Withdraw(withdraw.getIdOwner()));
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("message", "Withdraw successfully");
        return modelAndView ;
    }
}
