package com.snoweagle.dc;

import com.snoweagle.dc.domain.common.ServerConfig;
import com.snoweagle.dc.domain.server.PushServer;
import com.snoweagle.dc.domain.ws.WebsocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BootstrapApp
{
    public static void main(String[] args) {
        SpringApplication.run(BootstrapApp.class);

        serverStart();
    }

    private static void serverStart(){
        log.info("netty start..");

        PushServer pushServer = new PushServer(ServerConfig.builder().port(9901).build());
        pushServer.start();
        log.info("push server start success!");

        WebsocketServer websocketServer = new WebsocketServer(ServerConfig.builder().port(9900).build());
        websocketServer.start();

        log.info("ws server start success!");
    }
}
