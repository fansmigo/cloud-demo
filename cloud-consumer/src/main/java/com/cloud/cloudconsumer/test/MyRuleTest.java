package com.cloud.cloudconsumer.test;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import java.util.List;

public class MyRuleTest implements IRule {

  ILoadBalancer lb;

  public MyRuleTest() {

  }

  public MyRuleTest(ILoadBalancer lb) {
    this.lb = lb;
  }

  @Override
  public Server choose(Object key) {
    // 获取全部服务器
    List<Server> servers = lb.getAllServers();
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
