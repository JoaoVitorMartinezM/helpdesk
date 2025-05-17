package com.devmarcelino.helpdesk.services;

import com.devmarcelino.helpdesk.dto.CustomerRecord;
import com.devmarcelino.helpdesk.models.Customer;
import com.devmarcelino.helpdesk.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public Optional<Long> createService(CustomerRecord customerRecord) {
        Customer customerModel = new Customer();
        BeanUtils.copyProperties(customerRecord, customerModel);
        Customer customer = customerRepository.save(customerModel);
        return Optional.of(customer.getCnpj());
    }

    public List<CustomerRecord> retrieveCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerRecord> mappedList = customers.stream().map(c -> new CustomerRecord(c.getCnpj(), c.getTradeName(), c.getCompanyName())).toList();
        return mappedList;
    }
}

