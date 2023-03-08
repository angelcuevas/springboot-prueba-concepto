package com.angelcuevas.ProductService.controllers;

import com.angelcuevas.ProductService.entities.Product;
import com.angelcuevas.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity getAll(){
        List<Product> products = productService.getAll();
        if(products.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity getById(@PathVariable int productId){
        Product found = productService.getProductById(productId);
        if(found == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(found, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Product product){
        Product savedProduct = productService.save(product);
        return new ResponseEntity(savedProduct, HttpStatus.OK);
    }
}
