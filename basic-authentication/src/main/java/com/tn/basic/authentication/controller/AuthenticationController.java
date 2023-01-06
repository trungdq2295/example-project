package com.tn.basic.authentication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AuthenticationController {

    @GetMapping
    public ResponseEntity getAuthenticationUser(){
        return ResponseEntity.ok(SecurityContextHolder.getContext().getAuthentication());
    }
}
