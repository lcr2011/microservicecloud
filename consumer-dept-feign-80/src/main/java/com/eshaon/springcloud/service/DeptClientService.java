package com.eshaon.springcloud.service;

import com.eshaon.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * TODO
 *
 * @author eshaon
 * @date 2019/08/06
 */
@FeignClient(value = "PROVIDER-DEPT")
@RequestMapping(path = "/com", produces = "application/json")
public interface DeptClientService {

    /**
     * get specified dept info according to deptNo.
     *
     * @param id "deptNo"
     * @return
     */
    @RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id);

    /**
     * get all dept info.
     *
     * @return
     */
    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    public List<Dept> list();

    /**
     * add dept info to database.
     *
     * @param dept
     * @return
     */
    @RequestMapping(value = "/dept", method = RequestMethod.POST)
    public boolean add(Dept dept);

}
