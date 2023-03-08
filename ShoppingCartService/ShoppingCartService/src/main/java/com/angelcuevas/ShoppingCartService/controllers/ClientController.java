package com.angelcuevas.ShoppingCartService.controllers;

import com.angelcuevas.ShoppingCartService.entities.Client;
import com.angelcuevas.ShoppingCartService.models.Product;
import com.angelcuevas.ShoppingCartService.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping
    public ResponseEntity getAll(){
        List<Client> products = clientService.getAll();
        if(products.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity getById(@PathVariable int productId){
        Client found = clientService.getProductById(productId);
        if(found == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(found, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Client product){
        Client savedClient = clientService.save(product);
        return new ResponseEntity(savedClient, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity saveProduct(@RequestBody Product product){
        Product newProduct = clientService.saveProduct(product);
        return new ResponseEntity(newProduct, HttpStatus.OK);
    }
}
