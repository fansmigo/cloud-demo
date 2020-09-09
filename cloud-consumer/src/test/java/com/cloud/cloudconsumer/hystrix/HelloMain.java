package com.cloud.cloudconsumer.hystrix;

import org.junit.jupiter.api.Test;

public class HelloMain {

  @Test
  public void testNormal(){
    // 请求正常的服务
    String normalUrl = "http://localhost:8031/normalHello";
    HelloCommond commond = new HelloCommond(normalUrl);
    String result = commond.execute();
    System.out.println("请求正常的服务，结果：" + result);

  }

  @Test
  public void testError(){
    // 请求异常的服务
    String normalUrl = "http://localhost:8031/errorHello";
    HelloCommond commond = new HelloCommond(normalUrl);
    String result = commond.execute();
    System.out.println("请求异常的服务，结果：" + result);
  }
}
