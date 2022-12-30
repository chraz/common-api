package com.example.backendapi.controller;


import com.example.backendapi.model.Product;
import com.example.backendapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/")
public class ProductController {

    @Autowired
    private ProductService productService;



    @RequestMapping(value="/products", method = GET, produces = "application/json")
    public List<Product> getProducts() {return productService.getAllProducts();}

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteProduct(@PathVariable Long id)  {  productService.deleteProduct(id);
    }


   /* @CrossOrigin
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }*/

    @CrossOrigin
    @GetMapping("/productsdetailed")
    public List<Product> getAllProductsDetailed(){
        return productService.getAllProductsDetailed();
    }

    /*

    @CrossOrigin
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @CrossOrigin
    @GetMapping("/productsdetailed")
    public List<Product> getAllProductsDetailed(){
        return productService.getAllProductsDetailed();
    }
*/

}
