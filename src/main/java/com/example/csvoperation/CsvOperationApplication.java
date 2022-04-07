package com.example.csvoperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CsvOperationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsvOperationApplication.class, args);
    }

}
