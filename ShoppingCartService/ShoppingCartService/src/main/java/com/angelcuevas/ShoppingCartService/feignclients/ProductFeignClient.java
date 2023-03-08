package com.angelcuevas.ShoppingCartService.feignclients;

import com.angelcuevas.ShoppingCartService.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-service", url= "http://localhost:8081", path = "/v1/product")
public interface ProductFeignClient {
    @PostMapping
    public Product save(@RequestBody Product project);
}
