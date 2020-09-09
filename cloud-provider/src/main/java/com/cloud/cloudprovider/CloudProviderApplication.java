package com.cloud.cloudprovider;

import com.cloud.cloudprovider.rabbit.SendService;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * 在启动类上加入@EnableDiscoveryClient注解，声明该微服务注册到服务注册中心
 * 在启动类上加入@EnableBinding注解，在Spring容器启动时，会自动绑定SendService接口种定义的通道：myInput。
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableBinding(SendService.class)
public class CloudProviderApplication {

  /**
   * 此处可以启动多个cloud-provider服务，但是端口不一样，类似服务集群
   * @param args
   */
  public static void main(String[] args) {
    // 读取控制台输入作为端口参数
    Scanner scan = new Scanner(System.in);
    String port = scan.nextLine();
    // 设置启动的服务端口
    new SpringApplicationBuilder(CloudProviderApplication.class)
        .properties("server.port=" + port).run(args);
  }

}
