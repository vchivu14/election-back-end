package com.example.elect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class ElectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElectApplication.class, args);
    }

}
