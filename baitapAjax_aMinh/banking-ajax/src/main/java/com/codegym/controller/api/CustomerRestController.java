package com.codegym.controller.api;

import com.codegym.model.Customer;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService ;

    @GetMapping
    public ResponseEntity<Page<Customer>> allCustomers(@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>( customerService.findAllNoDelete(pageable), HttpStatus.OK);
    }
}
