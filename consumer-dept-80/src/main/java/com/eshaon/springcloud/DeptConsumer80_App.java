package com.eshaon.springcloud;

import com.eshaon.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author eshaon
 */
//添加@RibbonClient注解后，在启动该微服务时就能去加载自定义的Ribbon配置类，从而使配置生效。
@RibbonClient(name="PROVIDER-DEPT", configuration = MySelfRule.class)
//@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }

}
