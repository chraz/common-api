package com.example.backendapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backendapi.model.Customer;
import com.example.backendapi.service.CustomerService;



import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
@RestController
@RequestMapping("/api/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/customer", method = GET, produces = "application/json")
    public List<Customer> getCustomers() {return customerService.getCustomers();}

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable Long id)  {  customerService.deleteCustomer(id);
    }

}
