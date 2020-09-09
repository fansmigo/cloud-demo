package com.cloud.cloudconsumer;

import com.cloud.cloudconsumer.rabbit.ReceiveService;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 *在启动类上加入@EnableDiscoveryClient注解，声明该微服务注册到服务注册中心
 *加入@EnableFeignClients，声明使用Feign调用接口，允许服务调用
 * 加入@EnableCircuitBreaker，启用Hystrix断路器
 * 加入@EnableZuulProxy，启用Zuul网关服务
 * 加入@@EnableBinding，开启绑定，并声明通道的接口类
 *
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
//@EnableCircuitBreaker
//@ServletComponentScan
//@EnableZuulProxy
@EnableBinding(ReceiveService.class)
public class CloudConsumerApplication {

  public static void main(String[] args) {
//    SpringApplication.run(CloudConsumerApplication.class, args);

    // 读取控制台输入作为端口参数
    Scanner scan = new Scanner(System.in);
    String port = scan.nextLine();
    // 设置启动的服务端口
    new SpringApplicationBuilder(CloudConsumerApplication.class)
        .properties("server.port=" + port).run(args);
  }

  // @StreamListener注解：声明了订阅myInput通道的消息。
  @StreamListener("myInput")
  public void receive(byte[] msg){
    System.out.println("接收到的消息：" + new String(msg));
  }

}
