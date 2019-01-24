package com.wj.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangjie
 * @data 2019/1/15 15:47
 */
@Data
public class User implements Serializable {
//    private static final long serialVersionUID = 1L;
    private Integer id;
    private String userName;
    private String sex;
    private String birthday;
    private Integer deleted;

}
