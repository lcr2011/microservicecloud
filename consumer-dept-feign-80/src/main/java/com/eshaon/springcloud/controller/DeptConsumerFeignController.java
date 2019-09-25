package com.eshaon.springcloud.controller;

import com.eshaon.springcloud.entities.Dept;
import com.eshaon.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author eshaon
 * @date 2019/08/06
 */
@RestController
@RequestMapping(path = "/consumer", produces = "application/json")
public class DeptConsumerFeignController {

    @Autowired
    private DeptClientService clientService = null;

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return this.clientService.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return this.clientService.list();
    }

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public Object add(Dept dept) {
        return this.clientService.add(dept);
    }

}
