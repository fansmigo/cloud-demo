package com.cloud.cloudprovider.controller;

import com.cloud.cloudprovider.rabbit.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RabbitMQ队列消息的生产者
 */
@RestController
public class ProducerController {

  @Autowired
  SendService sendService;

  @RequestMapping(value = "/send/{message}", method = RequestMethod.GET)
  public String sendRequest(@PathVariable("message") String message){
    System.out.println("cloud-provider 生产者推送的消息：" + message);
    // 创建消息
    Message msg = MessageBuilder.withPayload(message.getBytes()).build();
    // 发送消息
    sendService.sendOrder().send(msg);
    return "success";
  }
}
