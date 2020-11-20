package com.example.mfsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@tk.mybatis.spring.annotation.MapperScan("com.example.mfsp.dao")
@SpringBootApplication
public class MfspApplication {

    public static void main(String[] args) {
        SpringApplication.run(MfspApplication.class, args);
    }

}
