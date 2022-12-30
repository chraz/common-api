package com.example.backendapi.repository;

import com.example.backendapi.model.Order;
import com.example.backendapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //List<Order> findByCustomer(Customer customer);
}
