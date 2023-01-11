package com.example.backendapi.service;

import com.example.backendapi.model.Customer;
import com.example.backendapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomer(String id) {
        return customerRepository.findById(id);
    }


    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

}
