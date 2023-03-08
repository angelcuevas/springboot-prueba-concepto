package com.angelcuevas.ShoppingCartService.services;

import com.angelcuevas.ShoppingCartService.entities.Client;
import com.angelcuevas.ShoppingCartService.feignclients.ProductFeignClient;
import com.angelcuevas.ShoppingCartService.models.Product;
import com.angelcuevas.ShoppingCartService.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Client getProductById(int productId){
        return clientRepository.findById(productId).orElse(null);
    }

    public Client save(Client product){
        Client savedClient = clientRepository.save(product);
        return savedClient;
    }
    public Product saveProduct(@RequestBody Product product){
        Product savedProduct = productFeignClient.save(product);
        return savedProduct;
    }

}
