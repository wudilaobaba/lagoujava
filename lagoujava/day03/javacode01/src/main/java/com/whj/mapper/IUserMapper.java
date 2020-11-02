package com.whj.mapper;

import com.whj.pojo.Order;
import com.whj.pojo.User;

import java.util.List;

public interface IUserMapper {
    void insertUser(User user);

    //查询订单的同时，查询该订单所属的用户
    List<Order> findOrderAndUser();
}
