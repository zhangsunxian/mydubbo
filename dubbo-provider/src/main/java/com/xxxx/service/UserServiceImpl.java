package com.xxxx.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xxxx.mapper.UserMapper;
import com.xxxx.pojo.User;
import com.xxxx.api.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhuyp
 * @create 2021-01-22 16:13
 */
@Service
@Component
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("小张");
        System.out.println("服务端接收到id：" + id);
        return user;
    }

    @Override
    public User getUserFromMysql(Integer id) {

        System.out.println("服务端接收到id：" + id);
        User user = userMapper.getUserFromMysql(id);

        return user;
    }
}
