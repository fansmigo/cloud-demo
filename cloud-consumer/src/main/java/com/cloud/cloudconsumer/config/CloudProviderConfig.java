package com.cloud.cloudconsumer.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 此处亦可以通过配置文件appliction.yml设置Ribbon
 */
@RibbonClient(name = "cloud-provider", configuration = MyConfig.class)
public class CloudProviderConfig {

}
