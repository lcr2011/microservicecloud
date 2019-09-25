package com.eshaon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），
 * @EnableDiscoveryClient 基于 spring-cloud-commons,
 * @EnableEurekaClient 基于 spring-cloud-netflix。
 * 其实用更简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient;
 * 如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
 */
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class DeptProvider8001_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }

}
