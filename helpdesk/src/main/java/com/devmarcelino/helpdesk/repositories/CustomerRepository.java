package com.devmarcelino.helpdesk.repositories;

import com.devmarcelino.helpdesk.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
