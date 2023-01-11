package com.example.backendapi.controller;


import com.example.backendapi.model.Recommendation;
import com.example.backendapi.model.SupportTask;
import com.example.backendapi.repository.CustomerRepository;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.backendapi.model.Customer;
import com.example.backendapi.service.CustomerService;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value="/customer", method = GET, produces = "application/json")
    public List<Customer> getCustomers() {return customerService.getCustomers();}

    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomer(@PathVariable String  CustomerID) {
        return customerService.getCustomer(CustomerID);
    }

   /* @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }*/

    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable String CustomerID)  {  customerService.deleteCustomer(CustomerID);
    }


    @PostMapping("/customer")
    public String addCustomer(@Validated @NonNull @RequestBody Customer customer) {
        customerRepository.save(customer);
        return "OK";
    }


    /**
     * Customer-Support-Service
     */


    @GetMapping("/tasks")
    public Mono<List<SupportTask>> getSupportTasks() {
        WebClient client = WebClient.create("http://localhost:8882"); // The URL of the customer-support-service
        return client.get().uri("/api/v1/tasks")
                .retrieve().bodyToMono(new ParameterizedTypeReference<List<SupportTask>>() {});
    }

    @GetMapping("/tasks/{customerId}")
    public Mono<List<SupportTask>> getSupportTasksbycust(@PathVariable long customerId) {
        WebClient client = WebClient.create("http://localhost:8882"); // The URL of the customer-support-service
        return client.get().uri("/api/v1/tasks/{customerId}",customerId)
                .retrieve().bodyToMono(new ParameterizedTypeReference<List<SupportTask>>() {});
    }

    @PostMapping("/task")
    public void addtask(@RequestBody SupportTask supporttask) {
        WebClient client = WebClient.create("http://localhost:8882");
        var result = client.post()
                .uri("/api/v1/task")
                .body(Mono.just(supporttask), Recommendation.class)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
    }


  /*  private static class SupportTask {
        public String getStatus() {
                return status;}
            public void setStatus(String status) {
                this.status = status;}

            public String getPriority() {
                return priority;}

            public void setPriority(String priority) {
                this.priority = priority;}

            //EnumSet<Status> status = EnumSet.of(Status.DONE, Status.PENDING, Status.INPROGRESS);

            public enum Status {
                PENDING, INPROGRESS, DONE}

            private Long id;

            protected long customerId;

            private String priority;

            private String status ;

            public Long getId() {
                return id;}

            public void setId(Long id) {
                this.id = id;}

            public long getCustomerId() {
                return customerId;
            }
            public void setCustomerId(long customerId) {
                this.customerId = customerId;
            }
    }*/
}
