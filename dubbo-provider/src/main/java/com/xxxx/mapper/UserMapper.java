package com.xxxx.mapper;

import com.xxxx.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhuyp
 * @create 2021-01-25 17:03
 */
@Mapper
public interface UserMapper {
    public User getUserFromMysql(@Param("id") Integer id);

}
