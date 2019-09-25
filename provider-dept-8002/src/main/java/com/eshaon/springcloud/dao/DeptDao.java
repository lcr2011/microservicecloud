package com.eshaon.springcloud.dao;

import com.eshaon.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2019-07-20.
 */
@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();

}
