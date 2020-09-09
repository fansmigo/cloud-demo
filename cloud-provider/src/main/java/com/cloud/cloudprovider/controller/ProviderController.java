package com.cloud.cloudprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务端
 */
@RestController
public class ProviderController {

  @RequestMapping("/sayhello")
  public String sayHello(){
    return "我是来自provider服务端，你好呀！";
  }
}
