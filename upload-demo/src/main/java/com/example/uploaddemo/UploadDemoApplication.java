package com.example.uploaddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class UploadDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadDemoApplication.class, args);
	}

}
