package com.cloud.cloudconsumer.test;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;

/**
 * 测试Ribbon类
 */
public class RestClientTest {

  public static void main(String[] args) {
    // 设置请求的服务器
    // my-client 对应客户端服务的名称。
    ConfigurationManager.getConfigInstance().setProperty(
        "my-client.ribbon.listOfServers",
        "localhost:8080, localhost:8081");

    // 获取REST客户端请求
    RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
    // 创建请求实例
    HttpRequest request = HttpRequest.newBuilder().uri("/person/1").build();

    // 发送6此请求到服务器中
    for (int i = 0; i < 6 ; i++) {
//      HttpResponse response = client.executeWithLoadBalancer(request);
//      String result = response.getEntity(String.class);
//      System.out.println(result);
    }
  }

}
