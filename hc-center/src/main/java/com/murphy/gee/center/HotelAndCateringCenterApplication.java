package com.murphy.gee.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HotelAndCateringCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelAndCateringCenterApplication.class, args);
    }

}
