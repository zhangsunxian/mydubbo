package com.xxxx.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xxxx.pojo.User;
import com.xxxx.api.UserServiceI;
import org.springframework.stereotype.Component;

/**
 * @author zhuyp
 * @create 2021-01-22 16:13
 */
@Service
@Component
public class UserServiceImpl implements UserServiceI {
    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("小张");
        System.out.println("服务端接收到id：" + id);
        return user;
    }
}
