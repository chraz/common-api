package com.example.backendapi.service;

import com.example.backendapi.model.Customer;
import com.example.backendapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.getReferenceById(id);
    }


    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        //  this.getCustomers();
    }

}
