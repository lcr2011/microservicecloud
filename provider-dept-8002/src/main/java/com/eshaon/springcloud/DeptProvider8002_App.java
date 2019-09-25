package com.eshaon.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName com.eshaon.springcloud.DeptProvider8002_App
 * @Description TODO
 * @Author Eshaon
 * @Date 2019/08/05
 * @Version v1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class DeptProvider8002_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002_App.class, args);
    }
}
