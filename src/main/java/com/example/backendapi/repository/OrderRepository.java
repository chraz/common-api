package com.example.backendapi.repository;

import com.example.backendapi.model.Customer;
import com.example.backendapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findByCustomer(Customer customer);
}
