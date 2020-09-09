package com.cloud.clouddiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 在启动类上加入@EnableEurekaServer注解，声明这是一个服务注册中心
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudDiscoveryApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudDiscoveryApplication.class, args);
  }

}
