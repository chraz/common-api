package com.example.backendapi.service;

import com.example.backendapi.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Map;


@Service
public class OrderService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Order> getAllorders() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Order> orders = new ArrayList<>();
        String query = "select OrderID, CustomerID, OrderDate, RequiredDate, ShippedDate from orders";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        for (Map row : rows) {
            Order order = new Order();

            order.setOrderID((Integer) row.get("OrderID"));
            order.setCustomerID((String) row.get("CustomerID"));
            order.setOrderDate((Date) row.get("OrderDate"));
            order.setRequiredDate((Date) row.get("RequiredDate"));
            order.setShippedDate((Date) row.get("ShippedDate"));

            orders.add(order);
        }

        return orders;
    }

    public int deleteOrder(Long orderId) {
        //TODO Implement DAO to replace this
        String deleteQueryDetails = "delete from `order details` where OrderID = ?";
        jdbcTemplate.update(deleteQueryDetails, orderId);
        String deleteQueryOrder = "delete from orders where OrderID = ?";
        int numUpdated = jdbcTemplate.update(deleteQueryOrder, orderId);
        return numUpdated;
    }

    public int addOrder(String customerId, Long productId) {
        return 0;
    }
}