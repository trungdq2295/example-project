package com.example.grpc.grpc.client.service;

import com.example.grpc.EmployeeRequest;
import com.example.grpc.EmployeeServiceGrpc;
import com.example.grpc.grpc.client.model.EmployeeResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @GrpcClient("greeting-service")
    private EmployeeServiceGrpc.EmployeeServiceBlockingStub employeeServiceBlockingStub;

    public EmployeeResponse getEmployee() {
        EmployeeRequest request = EmployeeRequest.newBuilder().setEmpId("Test").build();
        EmployeeResponse response = new EmployeeResponse(employeeServiceBlockingStub.getEmployee(request).getName());
        return response;
    }
}
