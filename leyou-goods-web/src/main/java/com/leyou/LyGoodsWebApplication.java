package com.leyou;

import com.config.GracefulShutdownTomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @Author: 98050
 * Time: 2018-10-17 11:10
 * Feature: 商品详情微服务启动器，开启fegin功能
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LyGoodsWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyGoodsWebApplication.class,args);
    }

    @Autowired
    private GracefulShutdownTomcat gracefulShutdownTomcat;

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers(gracefulShutdownTomcat);
        return tomcat;
    }
}
