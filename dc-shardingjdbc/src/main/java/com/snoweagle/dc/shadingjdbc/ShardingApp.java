package com.snoweagle.dc.shadingjdbc;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.snoweagle.dc.shadingjdbc.infra.dal.mapper"})
@Slf4j
public class ShardingApp {
    public static void main(String[] args) {
        SpringApplication.run(ShardingApp.class);
    }
}
