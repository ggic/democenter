package com.snoweagle.dc.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RedisApp {
    public static void main(String[] args) {
        SpringApplication.run(RedisApp.class);
    }
}
