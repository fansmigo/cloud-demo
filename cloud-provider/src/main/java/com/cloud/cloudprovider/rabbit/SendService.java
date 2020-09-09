package com.cloud.cloudprovider.rabbit;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface SendService {

  /**
   * 注解 @Output("myInput")：表示会创建myInput的消息通道，调用该方法后，会向myInput通道投递消息。
   * 如果注解 @Output 不提供参数，则使用方法名作为通道名称。
   * @return
   */
  @Output("myInput")
  SubscribableChannel sendOrder();
}
