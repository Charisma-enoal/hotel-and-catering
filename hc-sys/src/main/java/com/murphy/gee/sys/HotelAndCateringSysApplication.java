package com.murphy.gee.sys;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDistributedTransaction
public class HotelAndCateringSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelAndCateringSysApplication.class, args);
    }

}
