package com.xxxx.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhuyp
 * @create 2021-01-22 16:10
 */
@Data
@ApiModel(value = "User对象",description = "用户对象User")
public class User implements Serializable {

    @ApiModelProperty(value = "用户id",name = "id")
    private Integer id;

    @ApiModelProperty(value = "用户姓名",name = "name",example = "张三")
    private String name;

    @ApiModelProperty(value = "用户年龄",name = "age",example = "24")
    private Integer age;

}
