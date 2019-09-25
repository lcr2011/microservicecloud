package com.eshaon.springcloud.controller;

import com.eshaon.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.eshaon.springcloud.service.DeptService;

import java.util.List;

/**
 * @author eshaon
 * Created by Administrator on 2019-07-20.
 */
@RestController
@RequestMapping(path = "/com", produces = "application/json")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept", method = RequestMethod.GET)
    public Dept get(@RequestParam(name = "deptNo") Long id) {
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
    public Dept get2(@PathVariable Long id) {
        return deptService.get(id);
    }

    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list();
    }

    @RequestMapping(value = "/dept", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("PROVIDER-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t"
                    + element.getPort() + "\t" + element.getUri());
        }
        return this.discoveryClient;
    }

}
