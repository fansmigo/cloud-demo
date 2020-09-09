package com.cloud.cloudconsumer.hystrix;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy;

/**
 * 信号量隔离策略
 */
public class SemaphoreIso {

  public static void main(String[] args) throws Exception{
    // 配置使用信号量隔离策略进行隔离
    ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.isolation.strategy", ExecutionIsolationStrategy.SEMAPHORE);
    // 设置最大并发数，默认值时10，本例设置为2
    ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.isolation.semaphore.maxConcurrentRequests", 2);
    // 设置执行回退方法的最大并发，默认值时10，本例设置为20
    ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.fallback.isolation.semaphore.maxConcurrentRequests", 20);
    for (int i = 0; i < 6; i++) {
      final int index = i;
      Thread t = new Thread(){
        public void run(){
          MyCommand c = new MyCommand(index);
          // execute：调用queue的get方法返回命令的执行结果，该方法同步执行
          c.execute();
        }
      };
      t.start();
    }
    Thread.sleep(5000);
  }
}
