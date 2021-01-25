package com.xxxx.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xxxx.pojo.User;
import com.xxxx.api.UserServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhuyp
 * @create 2021-01-22 16:17
 */
@Controller
public class UserController {

    @Reference
    private UserServiceI serviceI;

    @ResponseBody
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public User getUser(@RequestParam("id") Integer id) {
        User userById = serviceI.getUserById(id);
        System.out.println("客户端获取到数据："+userById);
        return userById;
    }

    @ResponseBody
    @RequestMapping(value = "/getUserFromMysql",method = RequestMethod.GET)
    public User getUserFromMysql(@RequestParam("id") Integer id) {
        User userById = serviceI.getUserFromMysql(id);
        System.out.println("客户端获取到数据："+userById);
        return userById;
    }

}
