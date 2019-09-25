package com.eshaon.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 注解@Configuration作用于类上，相当于一个xml文件.
 * boot -->spring  applicationContext.xml --- @Configuration配置   ConfigBean = applicationContext.xml
 *
 * @author eshaon
 */
@Configuration //通过@Configuration注解来表明该类是一个Spring的配置，相当于一个xml文件
public class ConfigBean {

    /**
     * 注解@LoadBalanced：在使用Ribbon 时添加.
     * 注解@Bean：标注在方法上，相当于xml配置文件中的<bean/>
     *
     * @return
     */
    @LoadBalanced
    @Bean // (1)通过@Bean注解来表明是一个Bean对象，相当于xml中的<bean>；
    // (2)注意：方法名是作为返回对象的名字的，因此一般不带get，也就是上述放入spring容器的bean的name为getUserDAO
    public RestTemplate getRestTemplate() {
        return new RestTemplate(); // 直接new对象做演示
    }

    /**
     * Custom load balancing algorithm: use RandomRule instead of RoundRobinRule.
     *
     * @return
     */
/*    @Bean
    public IRule myRule() {
        //return new RoundRobinRule();
        return new RandomRule();
        //return new RetryRule(); //重试算法
    }*/

}

/*
@Bean
public UserServcie getUserServcie() {
	return new UserServcieImpl();
}
 applicationContext.xml == ConfigBean(@Configuration)
<bean id="userServcie" class="com.atguigu.tmall.UserServiceImpl">
*/
