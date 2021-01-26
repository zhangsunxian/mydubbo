package com.xxxx.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xxxx.pojo.User;
import com.xxxx.api.UserServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhuyp
 * @create 2021-01-22 16:17
 */
@RestController
@Api(value="用户controller",tags={"用户消费操作接口"})
public class UserController {

    @Reference
    private UserServiceI serviceI;

    @ApiOperation("查询虚拟用户信息")
    @GetMapping(value = "/get")
    public User getUser(@ApiParam(name="id",value="用户id",required=true) @RequestParam("id") Integer id) {
        User userById = serviceI.getUserById(id);
        System.out.println("客户端获取到数据："+userById);
        return userById;
    }

    @ApiOperation("从数据库中根据用户id查询用户信息")
    @GetMapping(value = "/getUserFromMysql")
    public User getUserFromMysql(@RequestParam("id") Integer id) {
        User userById = serviceI.getUserFromMysql(id);
        System.out.println("客户端获取到数据："+userById);
        return userById;
    }

}
