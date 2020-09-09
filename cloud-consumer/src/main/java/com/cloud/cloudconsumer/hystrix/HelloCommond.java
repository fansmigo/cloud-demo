package com.cloud.cloudconsumer.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HelloCommond extends HystrixCommand<String> {

  private String url;

  CloseableHttpClient httpClient;

  public HelloCommond(String url){
    // 调用父类构造器，设置命令组的key，默认用来作为线程池的key
    super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    // 创建HttpClient客户端
    this.httpClient = HttpClients.createDefault();
    this.url = url;
  }

  @Override
  protected String run() throws Exception {
    try{
      // 调用 GET 方法请求服务
      HttpGet httpGet = new HttpGet(url);
      // 得到服务相应
      HttpResponse response = httpClient.execute(httpGet);
      // 解析并返回命令执行结果
      return EntityUtils.toString(response.getEntity());
    }catch (Exception e){
      e.printStackTrace();
    }
    return "";
  }

  protected String getFallback(){
    System.out.println("执行 HelloCommand 的回退方法");
    return "error";
  }
}
