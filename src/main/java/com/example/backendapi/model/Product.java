package com.example.backendapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {


   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
   // private int id;
    @Id
    private int productID;

    @Column(name = "PRODUCTNAME")
    private String productName;
    private int supplierID;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID"),
            @JoinColumn(name = "CategoryName", referencedColumnName = "CategoryName")
    })
    private categories categories;

    private String quantityPerunit;
    private BigDecimal unitPrice;
    private int unitsInStock;
    private int unitsOnorder;
    private int Reorderlevel;
    private boolean isDiscontinued;
   // private int categoryID;

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


    public categories getCategories() {
        return categories;
    }

    public void setCategories(categories categories) {
        this.categories = categories;
    }

    public String getQuantityPerunit() {
        return quantityPerunit;
    }

    public void setQuantityPerunit(String QuantityPerUnit) {
        this.quantityPerunit = QuantityPerUnit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
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

    public void setCategoryID(Integer categoryID) {
    }


}
