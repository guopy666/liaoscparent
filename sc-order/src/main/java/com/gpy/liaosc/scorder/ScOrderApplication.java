package com.gpy.liaosc.scorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ScOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScOrderApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(){

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate;
    }

}
