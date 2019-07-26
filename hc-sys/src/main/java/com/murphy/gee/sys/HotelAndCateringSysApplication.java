package com.murphy.gee.sys;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDistributedTransaction
@MapperScan("com.murphy.gee.sys.mapper")
public class HotelAndCateringSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelAndCateringSysApplication.class, args);
    }

}
