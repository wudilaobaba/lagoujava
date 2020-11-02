package com.whj.mapper;

import com.whj.pojo.Order;
import com.whj.pojo.User;

import java.util.List;

public interface IUserMapper {
    //查询所有用户，同时查询每个用户关联的订单信息
    public List<User> findAll();
}
