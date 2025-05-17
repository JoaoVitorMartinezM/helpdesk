package com.devmarcelino.helpdesk.controllers;

import com.devmarcelino.helpdesk.dto.CustomerRecord;
import com.devmarcelino.helpdesk.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerRecord customerRecord){

        Optional<Long> cnpjOpt = customerService.createService(customerRecord);

        if (cnpjOpt.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerRecord>> retrieveCustomers(){
        return ResponseEntity.ok(customerService.retrieveCustomers());
    }


}
