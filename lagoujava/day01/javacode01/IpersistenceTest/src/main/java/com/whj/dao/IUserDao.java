package com.whj.dao;

import com.whj.pojo.User;

import java.util.List;

public interface IUserDao {
    //查询所有
    List<User> findAll() throws Exception;
    //根据条件进行查询
    User findByCondition(User user) throws Exception;
}
