package com.cloud.cloudconsumer.config;

import com.cloud.cloudconsumer.cloud.MyPing;
import com.cloud.cloudconsumer.cloud.MyRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

public class MyConfig {

  @Bean
  public IRule getRule() {
    return new MyRule();
  }

  @Bean
  public IPing getPing() {
    return new MyPing();
  }
}
