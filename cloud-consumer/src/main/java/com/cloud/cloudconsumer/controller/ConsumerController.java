package com.cloud.cloudconsumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费端
 */
@RestController
public class ConsumerController {
  @RequestMapping("/sayhello")
  public String sayHello(){
    return "我是来自consumer的服务端，你好呀！";
  }
}
