package com.example.backendapi.controller;


import com.example.backendapi.model.Order;
import com.example.backendapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllorders();
    }

    @CrossOrigin
    @DeleteMapping("/deleteOrder/{orderId}")
    public String delete(@PathVariable Long orderId) { return String.valueOf(orderService.deleteOrder(orderId)); }



    @CrossOrigin
    @GetMapping("/addOrder/{customerId}/{productId}/")
    public int add(@PathVariable String customerId, @PathVariable Long productId) {
        return orderService.addOrder(customerId, productId); }


    @PostMapping("/createOrder/{customerId}")
    public void createOrder(@PathVariable String customerId) {
        orderService.createOrder(customerId);
    }

    @GetMapping("/orders/{customerId}")
    public List<Order> getOrders(@PathVariable String customerId) {
        return orderService.getOrdersForCustomer(customerId);
    }

}