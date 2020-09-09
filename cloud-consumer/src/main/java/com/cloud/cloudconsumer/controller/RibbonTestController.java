package com.cloud.cloudconsumer.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class RibbonTestController {

  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }

  @RequestMapping(value = "/ribbon", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public String router() {
    RestTemplate rest = getRestTemplate();
    // 根据服务名调用服务
    String json = rest.getForObject("http://cloud-provider/person/1", String.class);
    return json;
  }
}
