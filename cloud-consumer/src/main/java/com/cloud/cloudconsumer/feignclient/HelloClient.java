package com.cloud.cloudconsumer.feignclient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "cloud-provider", fallback = HelloClientFallback.class)
public interface HelloClient {

  @RequestMapping(method = RequestMethod.GET, value = "/hello")
  public String hello();

//  static class HelloClientFallback implements HelloClient {
//    public String hello() {
//      System.out.println("hello 方法的回退");
//      return "error hello";
//    }
//  }
}
