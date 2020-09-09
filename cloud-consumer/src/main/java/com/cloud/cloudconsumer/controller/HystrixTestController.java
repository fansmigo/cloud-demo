package com.cloud.cloudconsumer.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixTestController {

  @GetMapping("/normalHello")
  public String normalHello(HttpServletRequest request){
    return "Hello World !!!";
  }

  /**
   * 默认情况下，如果调用的 Web 服务无法在1s内返回，那么将出发回退方法getFallback。
   * @param request
   * @return
   * @throws Exception
   */
  @GetMapping("/errorHello")
  public String errorHello(HttpServletRequest request) throws Exception{
    // 模拟需要处理10s
    Thread.sleep(10000);
    return "Error Hello World !!!";
  }
}
