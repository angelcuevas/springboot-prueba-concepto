package com.angelcuevas.ShoppingCartService.repositories;

import com.angelcuevas.ShoppingCartService.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
