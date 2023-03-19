package com.snoweagle.dc;

import com.snoweagle.dc.server.NettyServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BootstrapApp
{
    public static void main(String[] args) {
        SpringApplication.run(BootstrapApp.class);

        netty();
    }



    private static void netty(){
        log.info("netty start..");
        NettyServer server = new NettyServer();
        server.start();
        log.info("netty start success!");
    }
}
