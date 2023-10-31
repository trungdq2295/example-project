package com.example.democompletable.repository;


import com.example.democompletable.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShoppingRepository {


    private static final List<Product> listPrices = new ArrayList<>();

    static {
        listPrices.add(new Product("abc", 456));
        listPrices.add(new Product("xyz", 3123));
        listPrices.add(new Product("xyz321321", 78));
        listPrices.add(new Product("xy123z", 616));
    }

    public List<Product> getProduct() {
        return listPrices;
    }

}
