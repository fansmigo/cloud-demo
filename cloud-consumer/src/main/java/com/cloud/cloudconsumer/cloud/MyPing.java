package com.cloud.cloudconsumer.cloud;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

public class MyPing implements IPing {

  @Override
  public boolean isAlive(Server server) {

//    System.out.println("自定义Ping类，服务器信息：" + server.getHostPort());
    return true;
  }
}
