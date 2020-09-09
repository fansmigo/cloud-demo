package com.cloud.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 注解@EnableEurekaClient：在netflix包中，只适用于eureka作为注册中心的时候。
 * 注解@EnableDiscoveryClient：在common包中，对任何注册中心都适用。
 * 注解@EnableZuulProxy：启动类种加上此注解，就可以启动 Zuul 的网关代理功能。
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class CloudGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudGatewayApplication.class, args);
  }

}
