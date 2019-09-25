package com.eshaon.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author liuyuxiang
 * @date 2019-08-20  17:01
 */
@Configuration
public class MySelfRule {

    /**
     * @return
     */
    @Bean
    public IRule myRule() {
        //return new RandomRule(); // Ribbon 默认负载均衡算法为轮询，我们自定义为随机
        return new RandomRule_ZY();// 我自定义为每台机器5次
    }
}
