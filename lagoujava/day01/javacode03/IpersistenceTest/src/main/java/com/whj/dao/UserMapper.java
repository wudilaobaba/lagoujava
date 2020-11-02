package com.whj.dao;

import com.whj.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询所有
    List<User> findAll() throws Exception;
    //根据条件进行查询
    User findByCondition(User user) throws Exception;

    //修改
    void updateOne(User user);

    //新增
    void addAnUser(User user);

    //删除
    void delUser(User user);
}
