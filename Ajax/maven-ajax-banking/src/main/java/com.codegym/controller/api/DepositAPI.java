package com.codegym.controller.api;

import com.codegym.model.Customer;
import com.codegym.model.Deposit;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.deposit.IDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/deposits")
public class DepositAPI  {
    @Autowired
    private IDepositService depositService ;

    @Autowired
    private ICustomerService customerService ;

    @GetMapping
    public ResponseEntity<List<Deposit>> allCustomers() {
        List<Deposit> deposits = depositService.findAll();

        if (deposits.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(deposits, HttpStatus.ACCEPTED);
    }

    @PostMapping()
   public ResponseEntity<Deposit> handerDeposit(@RequestBody Deposit deposit){
        return new ResponseEntity<>(depositService.save(deposit),HttpStatus.OK);
    }



}
