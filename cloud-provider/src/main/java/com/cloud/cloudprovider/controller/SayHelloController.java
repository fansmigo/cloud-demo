package com.cloud.cloudprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {

  @RequestMapping("/hello")
  public String sayHello(){
    return "Hello, I'm from cloud-provider !";
  }
}
