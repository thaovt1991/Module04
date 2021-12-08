package com.codegym.controller;

import com.codegym.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    public static ArrayList<Customer> customersList ;

    static{
        Customer c1 = new Customer(1,"Tuong","tuong@gmail.com","123456","0972748562","12 Ly Thai To") ;
        Customer c2 = new Customer(2,"Minh","asdasdasdasdasdasd@gmail.com","123456","0942468213","12 Cong Uan") ;
        Customer c3 = new Customer(3,"Tuan Ngoc","asd@gmail.com","123456","513552468124","Le Huaan") ;
        Customer c4 = new Customer(4,"Khanh Bui","khanhtr@gmail.com","123456","01648246813","Li To") ;
        Customer c5 = new Customer(5,"Thanh Trung","tuoasdasng@gmail.com","123456","09724654555","Hue") ;

        customersList.add(c1);
        customersList.add(c2) ;
        customersList.add(c3);
        customersList.add(c4) ;
        customersList.add(c5);
    }


    @GetMapping("/customers")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        modelAndView.addObject("customers", customersList);
        return modelAndView;
    }
}

