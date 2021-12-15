package com.codegym.controller.api;

import com.codegym.model.Customer;
import com.codegym.model.Deposit;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.deposit.IDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerAPI {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IDepositService depositService;


    @GetMapping
    public ResponseEntity<List<?>> allCustomers() {
        List<Customer> customers = customerService.findAll();

        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = customerOptional.get();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Validated @RequestBody Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return appUtils.mapErrorToResponse(bindingResult);

        customerDTO.setBalance(BigDecimal.valueOf(0));

        try {
            return new ResponseEntity<>(customerService.save(customerDTO.toCustomer()), HttpStatus.CREATED);
            //        return new BaseResponse<Customer>().getValidResponse(201, "Successfully Created Customer", customerService.save(customerDTO.toCustomer()));
        } catch (DataIntegrityViolationException e) {
            throw new EmailExistsException("Email already exists");
        }
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Customer> updateCustomerByFull(@RequestBody Customer customer) {
        Long id = customer.getId();
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

    @PutMapping("/deposit/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Deposit deposit) {
        Optional<Customer> CustomerOptional = customerService.findById(id);

        if (!CustomerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = CustomerOptional.get();
        BigDecimal balanceCustomer = customer.getBalance() ;
        BigDecimal transactionAmountDeposit = deposit.getTransaction_amount() ;
        BigDecimal balanceAfterDeposit = balanceCustomer.add(transactionAmountDeposit) ;
        try {
            customer.setBalance(balanceAfterDeposit);
            deposit.setCustomer(customer);
            depositService.save(deposit);
            return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> CustomerOptional = customerService.findById(id);
        if (!CustomerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(CustomerOptional.get(), HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/deposit/{id}")
//    public ResponseEntity<Customer> depositCustomer(@RequestBody Customer customer) {
//        Long id = customer.getId() ;
//        Optional<Customer> customerOptional = customerService.findById(id);
//        if (!customerOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        customer.setId(customerOptional.get().getId());
//        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
//    }
}
