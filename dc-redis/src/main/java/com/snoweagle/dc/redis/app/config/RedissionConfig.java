package com.snoweagle.dc.redis.app.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @Author: snoweagle
 * @Date: 2021/5/31 下午1:38
 */
@Configuration
public class RedissionConfig {

    @Bean
    public RedissonClient getRedisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
        config.setLockWatchdogTimeout(150000);
        return Redisson.create(config);
    }
}
