package com.cloud.cloudconsumer.hystrix;

import com.netflix.config.ConfigurationManager;

/**
 * 线程隔离类
 */
public class ThreadIso {

  public static void main(String[] args) throws Exception{
    // 配置线程池大小为3
    ConfigurationManager.getConfigInstance().setProperty("hystrix.threadpool.default.coreSize", 3);
    for (int i = 0; i < 6; i++) {
      MyCommand c = new MyCommand(i);
      /**
       * queue：通过toObservable方法获得原始的Observable实例，
       * 在调用Observable的toBlocking方法得到一个BlockingObservable实例，
       * 最后调用BlockingBoservable的toFuture方法返回Future实例，
       * 调用Future的get方法得到执行结果
       */
      c.queue();
    }
    Thread.sleep(5000);
  }
}
