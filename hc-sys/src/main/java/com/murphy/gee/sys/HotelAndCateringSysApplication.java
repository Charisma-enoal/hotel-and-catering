package com.murphy.gee.sys;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
//@EnableDistributedTransaction
@MapperScan("com.murphy.gee.sys.mapper")
@ComponentScan({"com.murphy.gee.common","com.murphy.gee.sys"})
public class HotelAndCateringSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelAndCateringSysApplication.class, args);
    }

}
