package com.cloud.cloudconsumer.test;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试负载均衡器的负载均衡机制，默认使用RoundRobinRule（轮询）规则。
 */
public class ILoadBalancerTest {

  public void test() {
    // 创建负载均衡器
    ILoadBalancer ib = new BaseLoadBalancer();
    // 添加服务器
    List<Server> servers = new ArrayList<Server>();
    servers.add(new Server("localhost", 8080));
    servers.add(new Server("localhost", 8081));
    servers.add(new Server("localhost", 8082));
    ib.addServers(servers);
    // 进行6此服务器选择
    for (int i = 0; i < 6; i++) {
      Server s = ib.chooseServer(null);
      System.out.println(s);
    }

  }

}
