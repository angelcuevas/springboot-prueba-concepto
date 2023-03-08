package com.angelcuevas.ProductService.repositories;

import com.angelcuevas.ProductService.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
