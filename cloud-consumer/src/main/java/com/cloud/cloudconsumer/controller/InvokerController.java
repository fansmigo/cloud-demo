package com.cloud.cloudconsumer.controller;

import com.netflix.appinfo.InstanceInfo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaServiceInstance;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 查看Eureka界面中应用程序健康自检的效果
 */
@RestController
@Configuration
public class InvokerController {

  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping(value = "/router", method = RequestMethod.GET)
  public String router(){

    // 查找服务列表
    List<ServiceInstance> ins = getServiceInstances();
    // 接收返回信息
    StringBuilder sb = new StringBuilder();
    // 输出服务信息及状态
    for (ServiceInstance service : ins) {
      EurekaServiceInstance esi = (EurekaServiceInstance) service;
      InstanceInfo info = esi.getInstanceInfo();
//      System.out.println(info.getAppName() + "---" + info.getInstanceId() + "---" + info.getStatus());
      sb.append(info.getAppName())
          .append("---")
          .append(info.getInstanceId())
          .append("---")
          .append(info.getStatus())
          .append("\r\n");
    }
    return sb.toString();
  }

  /**
   * 查询可用服务
   * @return
   */
  private List<ServiceInstance> getServiceInstances() {
    // 获取Eureka的服务
    List<String> ids = discoveryClient.getServices();
    List<ServiceInstance> result = new ArrayList<ServiceInstance>();
    for (String id : ids) {
      List<ServiceInstance> ins = discoveryClient.getInstances(id);
      result.addAll(ins);
    }
    return result;
  }
}
