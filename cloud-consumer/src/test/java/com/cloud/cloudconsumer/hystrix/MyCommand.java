package com.cloud.cloudconsumer.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * 共用命令类，用于测试线程隔离与信号量隔离两个策略
 */
public class MyCommand extends HystrixCommand<String> {

  int index;

  private String key;

  public MyCommand(int index){
    super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")));
  }

  @Override
  protected String run() throws Exception {
    Thread.sleep(500);
    System.out.println("执行方法，当前索引：" + index);
    return "";
  }

  @Override
  protected String getFallback(){
    System.out.println("执行 fallback ，当前索引：" + index);
    return "";
  }

  @Override
  protected String getCacheKey(){
    return this.key;
  }
}
