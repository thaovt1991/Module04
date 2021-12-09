package com.codegym.controller.api;


import com.codegym.model.Smartphone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/smartphones")
public class SmartphoneRestController {

    @Autowired
    private ISmartphoneService smartphoneService;


    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> findCustomerById(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Smartphone smartphone = smartphoneOptional.get();

        return new ResponseEntity<>(smartphone, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Smartphone> updateCustomerByFull(@RequestBody Smartphone smartphone) {
        Long id = smartphone.getId() ;
        Optional<Smartphone> customerOptional = smartphoneService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphone.setId(customerOptional.get().getId());
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
}
