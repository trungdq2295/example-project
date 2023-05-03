package com.example.grpc.grpc.client.controller;

import com.example.grpc.grpc.client.service.EmployeeService;
import com.example.grpc.grpc.client.model.EmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public EmployeeResponse employeeResponse() {
        return employeeService.getEmployee();
    }
}
