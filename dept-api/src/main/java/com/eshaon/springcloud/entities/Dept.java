package com.eshaon.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 部门实体
 *
 * @author eshaon
 * @date 2019-07-20.
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept {

    /**
     * 主键
     */
    private Long deptNo;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 数据库源：微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
     */
    private String db_source;


}

