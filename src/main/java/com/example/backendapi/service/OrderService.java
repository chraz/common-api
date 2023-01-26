package com.example.backendapi.service;

import com.example.backendapi.model.Customer;
import com.example.backendapi.model.Order;
import com.example.backendapi.repository.CustomerRepository;
import com.example.backendapi.repository.OrderRepository;
import com.example.backendapi.repository.ProductRepository;
import jakarta.persistence.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;


@Service
@Convert(converter = LocalDateConverter.class)
public class OrderService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;


    public List<Order> getAllorders() {

    //    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Order> orders = new ArrayList<>();
        String query = "select OrderID, CustomerID, OrderDate, RequiredDate, ShippedDate from orders";

   //     ZoneId defaultZoneId = ZoneId.systemDefault();

        //creating the instance of LocalDate using the day, month, year info
     //   LocalDate localDate = LocalDate.of(2016, 8, 19);

        //local date + atStartOfDay() + default time zone + toInstant() = Date
   //     Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());


        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        for (Map row : rows) {
            Order order = new Order();

            order.setOrderID((Integer) row.get("OrderID"));
            order.setCustomerID((String) row.get("CustomerID"));
            order.setOrderDate((LocalDateTime) row.get("OrderDate"));
            order.setRequiredDate((LocalDateTime) row.get("RequiredDate"));
           order.setShippedDate((LocalDateTime) row.get("ShippedDate"));

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

   // public int addOrder(String customerId, Long productId) {


    public void createOrder(String customer_id) {
        Order order = new Order();
        Customer customer = customerRepository.getReferenceById(String.valueOf(customer_id));
        order.setCustomer(customer);
        orderRepository.save(order);
    }

    public List<Order> getOrdersForCustomer(String customerId) {
        Customer customer = customerRepository.getReferenceById(customerId.trim());
         return orderRepository.findByCustomer(customer);
    }

    public int addOrder(String customerId, Long productId) {
        Order order = new Order();
        order.setCustomerID(customerId);
        productRepository.getReferenceById(productId);
        order.setProduct( productRepository.getReferenceById(productId));
        orderRepository.save(order);

        return 5;
    }
}