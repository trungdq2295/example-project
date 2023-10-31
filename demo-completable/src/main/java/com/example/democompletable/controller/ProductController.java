package com.example.democompletable.controller;


import com.example.democompletable.model.Product;
import com.example.democompletable.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController {

    @Autowired
    ShoppingService service;

    @GetMapping
    public ResponseEntity<List<String>> getList(){
        return ResponseEntity.ok(service.findPrices());
    }
}
