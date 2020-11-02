package com.whj.dao;

import com.whj.pojo.User;

import java.io.IOException;
import java.util.List;

public interface IUserDao {
    //查询所有
    List<User> findAll();

    //根据id查询
    User findById(Integer id);

    //多条件组合查询，演示if
    public List<User> findByCondition(User user);

    //多值查询，演示foreach
    public List<User> findByIds(List<Integer> ids);
}
