package com.example.uploaddemo.service;

import com.example.uploaddemo.model.command.VendorCommand;
import com.example.uploaddemo.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    @Async
    public void saveAll(List<VendorCommand> vendorCommandList){
        System.out.println("Abc: " +System.currentTimeMillis());
        vendorRepository.saveAll(vendorCommandList);
        System.out.println("Abc: " +System.currentTimeMillis());
    }
}
