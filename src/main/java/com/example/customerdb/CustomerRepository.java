package com.example.customerdb;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastnameIgnoreCase(String search);
    List<Customer> findAllByState(String search1);
}
