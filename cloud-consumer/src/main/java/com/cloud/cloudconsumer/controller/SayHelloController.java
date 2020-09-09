package com.cloud.cloudconsumer.controller;

import com.cloud.cloudconsumer.feignclient.SayHelloConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ Author：chenxuebing
 * @ Date：2019/11/26 9:30
 * @ Description：打招呼的一个对象
 *
 * 在Idea的spring工程里，经常会遇到Could not autowire. No beans of 'xxxx' type found的错误提示。
 * 但程序的编译和运行都是没有问题的，这个错误提示并不会产生影响
 */

@RestController
public class SayHelloController {

  @Autowired
  private SayHelloConsumer caller;

  @RequestMapping("/sayHello")
  public String sayHello(){
    return caller.sayHello();
  }

//  @Bean
//  @LoadBalanced
//  public RestTemplate getRestTemplate(){
//    return new RestTemplate();
//  }
//
//  @RequestMapping(value = "/cSayHello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//  public String hello(){
//    RestTemplate rest = getRestTemplate();
//    // 根据应用名调用服务
//    String json = rest.getForObject("http://cloud-provider/hello", String.class);
//    return json;
//  }
}
