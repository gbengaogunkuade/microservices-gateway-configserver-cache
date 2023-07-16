package com.ogunkuade.specs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients     //ENABLE DISCOVERY OF CLIENTS
public class SpecsApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpecsApplication.class, args);
    }


}


