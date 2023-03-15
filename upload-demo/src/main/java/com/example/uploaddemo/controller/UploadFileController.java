package com.example.uploaddemo.controller;

import com.example.uploaddemo.excel.read.TraditionReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UploadFileController {

    @Autowired
    TraditionReadFile traditionReadFile;

    @GetMapping
    public ResponseEntity readFile(){
        traditionReadFile.readFile();
        return ResponseEntity.ok("Ok");
    }
}
