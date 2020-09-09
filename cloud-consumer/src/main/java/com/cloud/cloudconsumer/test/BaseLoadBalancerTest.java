package com.cloud.cloudconsumer.test;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import java.util.ArrayList;
import java.util.List;

public class BaseLoadBalancerTest {

  public void test() {

    // 创建负载均衡器
    BaseLoadBalancer blb = new BaseLoadBalancer();
    // 设置自定义的负载均衡规则
    // 注意：此处的MyRuleTest的参数blb，即：BaseLoadBalancer是实现了ILoadBalancer接口的。
    blb.setRule(new MyRuleTest(blb));
    // 添加服务器
    List<Server> servers = new ArrayList<Server>();
    servers.add(new Server("localhost", 8080));
    servers.add(new Server("localhost", 8081));
    servers.add(new Server("localhost", 8082));
    blb.addServers(servers);

    // 设置IPing实现类
//    blb.setPing(new PingUrl());
//    // 设置Ping的时间间隔为2秒
//    blb.setPingInterval(2);
//    Thread.sleep(6000);
//    for(Server server : blb.getAllServers()){
//      System.out.println(server.getHostPort() + "状态：" + server.isAlive());
//    }

    // 进行6此服务器选择
    for (int i = 0; i < 6; i++) {
      Server s = blb.chooseServer(null);
      System.out.println(s);
    }

  }
}
