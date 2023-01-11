package com.example.backendapi.repository;

import com.example.backendapi.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;




public interface CustomerRepository extends JpaRepository<Customer, String> {


}

