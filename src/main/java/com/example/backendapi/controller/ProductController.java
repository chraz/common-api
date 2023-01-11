package com.example.backendapi.controller;


import com.example.backendapi.model.Order;
import com.example.backendapi.model.Product;
import com.example.backendapi.model.Recommendation;
import com.example.backendapi.service.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private static Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;


    @RequestMapping(value="/products", method = GET, produces = "application/json")
    public List<Product> getProducts() {return productService.getAllProducts();}

    @GetMapping("/" +
            "}")
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

   /* @PostMapping("/recommendation")
    public void addRecommendation(@RequestBody Recommendation recommendation) {
        WebClient client = WebClient.create("http://recommendation-service.labnet.io:8888");
     //   WebClient client = WebClient.create("http://localhost:8888/");
        var result = client.post()
                .uri("/recommendation")
                .body(Mono.just(recommendation), Recommendation.class)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
    }

*/
    /*
    •Get all recommendationsGET /recommendationsReturns an array of recommendation objects•Add a recommendationPOST /recommendationProvide a recommendation as request objec
     */

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



  /*  @CrossOrigin
    @GetMapping("/productsdetailed")
    public List<Product> getAllProductsDetailed(){
        return productService.getAllProductsDetailed();
    }*/


    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getProductTypeSummary/{type}")
    public ResponseEntity<String> getProducts(@PathVariable String type) {
        try{
            ResponseEntity<String> response = restTemplate.exchange("http://localhost:8888/getProductDetailsByType/{type}",
                    HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, type);
            if(response.getStatusCode()== HttpStatus.OK) {
                return response;
            } else {
                logger.info("Failed to find products for type " + type);
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            logger.error("Failed " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/recommendations")
    public Mono<List<Recommendation>> getRecommendations() {

   //     WebClient client = WebClient.create("http://recommendation-service.labnet.io:8888");
        WebClient client = WebClient.create("http://localhost:8888");
        Mono<List<Recommendation>> recommendations;
        recommendations = client.get()
                .uri("/api/v1/recommendations")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });

        return recommendations;
    }

    @GetMapping("/recommendation/{id}")
    public List<Recommendation> getRecommendationprodid(@PathVariable long id) {
        WebClient client = WebClient.create("http://localhost:8888");
        Mono<List<Recommendation>> recommendations;
        recommendations = client.get()
                .uri("/api/v1/recommendation/{id}",id)
                .retrieve().
                bodyToMono(new ParameterizedTypeReference<>()
                {
                });

        return recommendations.block();
    }

    @PostMapping("/recommendation")
    public void addRecommendation(@RequestBody Recommendation recommendation) {
        WebClient client = WebClient.create("http://localhost:8888");
        var result = client.post()
                .uri("/api/v1/recommendation")
                .body(Mono.just(recommendation), Recommendation.class)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
    }


    @DeleteMapping("/delrecommendation/{id}")
    public void deleteRecommendation(@PathVariable long id) {
        WebClient client = WebClient.create("http://localhost:8888");
        var result = client.delete()
                .uri("/api/v1/delrecommendation/{id}",id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        logger.info("result: "+result);
    }



    }

