package com.angelcuevas.ProductService.services;

import com.angelcuevas.ProductService.entities.Product;
import com.angelcuevas.ProductService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getProductById(int productId){
        return productRepository.findById(productId).orElse(null);
    }

    public Product save(Product product){
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }
}
