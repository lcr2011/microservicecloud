package com.eshaon.springcloud.controller;

import com.eshaon.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * TODO
 *
 * @author Eshaon
 * @date 2019/08/02
 */
@RestController
@RequestMapping(path = "/consumer", produces = "application/json")
public class DeptConsumerController {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://PROVIDER-DEPT";  //需要配置Ribbon配置才可以使用

    /**
     * 使用restTemplate访问restful接口非常的简单。 (url, requestMap, ResponseBean.class) 这三个参数
     * 分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {

        return restTemplate.getForObject(REST_URL_PREFIX + "/com/dept/" + id, Dept.class);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {

        return restTemplate.getForObject(REST_URL_PREFIX + "/com/depts", List.class);
    }

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {

        return restTemplate.postForObject(REST_URL_PREFIX + "/com/dept", dept, Boolean.class);
    }

    /**
     * Consumer invoke Provider API
     *
     * @param
     * @return java.lang.Object
     */
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object consumerDiscovery() {

        return restTemplate.getForObject(REST_URL_PREFIX + "/com/dept/discovery", Object.class);
    }

}

