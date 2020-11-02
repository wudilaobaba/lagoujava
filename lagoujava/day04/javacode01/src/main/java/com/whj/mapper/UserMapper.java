package com.whj.mapper;

import com.whj.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getAllUsers();

    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);

    @Update("update user set username = #{username} where id = #{id}")
    void updateUser(User user);
}
