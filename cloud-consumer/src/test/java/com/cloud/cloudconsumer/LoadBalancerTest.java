package com.cloud.cloudconsumer;

import com.cloud.cloudconsumer.test.BaseLoadBalancerTest;
import com.cloud.cloudconsumer.test.ILoadBalancerTest;
import org.junit.jupiter.api.Test;

public class LoadBalancerTest {

  @Test
  public void test() {

    ILoadBalancerTest ilb = new ILoadBalancerTest();

    BaseLoadBalancerTest blb = new BaseLoadBalancerTest();

    ilb.test();
    System.out.println("----------------------------------");
    blb.test();
  }

}
