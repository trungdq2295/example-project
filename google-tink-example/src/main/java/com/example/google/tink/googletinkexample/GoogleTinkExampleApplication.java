package com.example.google.tink.googletinkexample;

import com.example.google.tink.googletinkexample.encryption.EncryptionUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GoogleTinkExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoogleTinkExampleApplication.class, args);
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        byte[] test = EncryptionUtil.encrypt(data);
        System.out.println("abc: " + EncryptionUtil.decrypt(test));
    }


}
