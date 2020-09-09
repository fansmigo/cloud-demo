package com.cloud.cloudconsumer.cloud;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import java.util.List;

public class MyRule implements IRule {

  private ILoadBalancer lb;

  public MyRule() {

  }

  public MyRule(ILoadBalancer lb) {
    this.lb = lb;
  }

  @Override
  public Server choose(Object key) {
    // 获取全部服务器
    List<Server> servers = lb.getAllServers();
    System.out.println("这个是自定义服务器规则类，输出服务器信息：");
    for (Server server : servers) {
      System.out.println("  "+ server.getHostPort());
    }
    // 只返回第一个对象
    return servers.get(0);
  }

  @Override
  public void setLoadBalancer(ILoadBalancer lb) {
    this.lb = lb;
  }

  @Override
  public ILoadBalancer getLoadBalancer() {
    return this.lb;
  }
}
