package com.eshaon.springcloud.service;


import com.eshaon.springcloud.entities.Dept;

import java.util.List;

/**
 * Created by Administrator on 2019-07-20.
 */
public interface DeptService {

    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}
