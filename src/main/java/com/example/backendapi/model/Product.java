package com.example.backendapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // private int id;
    private int productID;

    @Column(name = "NAME")
    private String productName;
    private int supplierID;
    private int categoryID;
    private String quantityPerunit;
    private double unitPrice;
    private int unitsInStock;
    private int unitsOnorder;
    private int Reorderlevel;
    private boolean isDiscontinued;

    public Product() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getQuantityPerunit() {
        return quantityPerunit;
    }

    public void setQuantityPerunit(String quantityPerunit) {
        this.quantityPerunit = quantityPerunit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public int getUnitsOnorder() {
        return unitsOnorder;
    }

    public void setUnitsOnorder(int unitsOnorder) {
        this.unitsOnorder = unitsOnorder;
    }

    public int getReorderlevel() {
        return Reorderlevel;
    }

    public void setReorderlevel(int reorderlevel) {
        Reorderlevel = reorderlevel;
    }

    public boolean isDiscontinued() {
        return isDiscontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        isDiscontinued = discontinued;
    }
}
