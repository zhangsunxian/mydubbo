package com.xxxx.api;

import com.xxxx.pojo.User;

/**
 * @author zhuyp
 * @create 2021-01-22 16:11
 */
public interface UserServiceI {

    public User getUserById(Integer id);

    User getUserFromMysql(Integer id);
}
