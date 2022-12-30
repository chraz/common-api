package com.example.backendapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="ORDERS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private int orderID;
        private String customerID;
        private Date orderDate;
        private Date requiredDate;
        private Date shippedDate;

        public Order() {
        }

        public Order(int orderID, String customerID, Date orderDate, Date requiredDate, Date shippedDate) {
            this.orderID = orderID;
            this.customerID = customerID;
            this.orderDate = orderDate;
            this.requiredDate = requiredDate;
            this.shippedDate = shippedDate;
        }

        public int getOrderID() {
            return orderID;
        }

        public void setOrderID(int orderID) {
            this.orderID = orderID;
        }

        public String getCustomerID() {
            return customerID;
        }

        public void setCustomerID(String customerID) {
            this.customerID = customerID;
        }

        public Date getOrderDate() {return orderDate;
        }

        public void setOrderDate(Date orderDate) {
            this.orderDate = orderDate;
        }

        public Date getRequiredDate() {
            return requiredDate;
        }

        public void setRequiredDate(Date requiredDate) {
            this.requiredDate = requiredDate;
        }

        public Date getShippedDate() {
            return shippedDate;
        }

        public void setShippedDate(Date shippedDate) {
            this.shippedDate = shippedDate;
        }


}
