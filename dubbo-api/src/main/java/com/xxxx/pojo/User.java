package com.xxxx.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhuyp
 * @create 2021-01-22 16:10
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

}
