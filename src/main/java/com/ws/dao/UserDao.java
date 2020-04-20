package com.ws.dao;

import com.ws.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component("userDao")
@Mapper
public interface UserDao {
    @Select("select user_id as userId,username,password from user where username=#{username} and password=#{password}")
    User findUser(
            @Param("username") String username,
            @Param("password") String password
    );
    @Select("select *from user where username=#{username}")
    User findUserByUsername(
            @Param("username") String username
    );

    int insert(@Param("user") User user);
}