package com.example.backendapi.controller;


import com.example.backendapi.model.Order;
import com.example.backendapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllorders();
    }

    @CrossOrigin
    @GetMapping("/deleteOrder/{orderId}")
    public int delete(@PathVariable Long orderId) { return orderService.deleteOrder(orderId); }



    @CrossOrigin
    @GetMapping("/addOrder/{customerId}/{productId}/")
    public int add(@PathVariable String customerId, @PathVariable Long productId) { return orderService.addOrder(customerId, productId); }


}