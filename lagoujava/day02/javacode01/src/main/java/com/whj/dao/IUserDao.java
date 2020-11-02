package com.whj.dao;

import com.whj.pojo.User;

import java.io.IOException;
import java.util.List;

public interface IUserDao {
    //查询所有
    List<User> findAll() throws Exception;
}
