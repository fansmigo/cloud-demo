package com.cloud.cloudconsumer.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @ Description：cloud-provider的SayHello类的方法
 */

/**
 * 调用者的接口方法是被调用者方法的声明，映射路径与被调用者方法的映射路径相同
 */
@FeignClient(value = "cloud-provider") //调用的服务名称
public interface SayHelloConsumer {

  @RequestMapping("/hello")
  String sayHello();
}
