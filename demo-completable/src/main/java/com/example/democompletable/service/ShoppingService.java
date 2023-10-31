package com.example.democompletable.service;


import com.example.democompletable.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ShoppingService {


    @Autowired
    ShoppingRepository repository;

    public List<String> findPrices() {
       return repository.getProduct().stream()
                .map(product -> CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return String.format("%s price is %.2f", product.getName(), product.getPrice());
                })).map(CompletableFuture::join).collect(Collectors.toList());
    }
}
