package com.example.backendapi.service;


import com.example.backendapi.model.Product;
import com.example.backendapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return this.getProducts(false);
    }

    public List<Product> getAllProductsDetailed(){
        return this.getProducts(true);
    }

     private List<Product> getProducts(boolean detailed){

       String query = "select ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued from products;";

        if(detailed){
            query = "select ProductID, ProductName, SupplierID, CategoryID, Quantity_PerUnit, Unit_Price, Units_In_Stock, Units_OnOrder, ReorderLevel, Discontinued from products;";
        }


        List<Product> products = new ArrayList<>();

        List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);
        for (Map row : rows) {
            Product product = new Product();

            product.setProductID((Integer)row.get("ProductID"));
            product.setProductName((String)row.get("ProductName"));
            product.setCategoryID((Integer)row.get("CategoryID"));
            product.setQuantityPerunit((String)row.get("QuantityPerUnit"));

           if(row.get("UnitPrice")!= null){product.setUnitPrice((BigDecimal) row.get("UnitPrice"));}
           if(row.get("UnitsInStock")!= null){product.setUnitsInStock((Integer)row.get("UnitsInStock"));}
       //     product.setUnitPrice(((BigDecimal)row.get("UnitPrice")).doubleValue());
          //  product.setUnitsInStock((Integer)row.get("UnitsInStock"));
            if(detailed){
                product.setSupplierID((Integer)row.get("SupplierID"));
                if(row.get("UnitsOnOrder")!= null){product.setUnitsOnorder((Integer)row.get("UnitsOnOrder"));}
              //  product.setUnitsOnorder((Integer)row.get("UnitsOnOrder"));
                product.setReorderlevel((Integer)row.get("ReorderLevel"));

                if(row.get("Discontinued")!= null){product.setDiscontinued((Boolean) row.get("Discontinued"));}
             //   product.setDiscontinued((Boolean) row.get("Discontinued"));
            }

            products.add(product);
        }

        return products;
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(Long id) {
        return productRepository.getReferenceById(id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
        this.getAllProductsDetailed();
    }
}