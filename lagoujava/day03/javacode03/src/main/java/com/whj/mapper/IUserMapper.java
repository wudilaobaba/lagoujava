package com.whj.mapper;

import com.whj.pojo.Order;
import com.whj.pojo.Role;
import com.whj.pojo.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface IUserMapper {
    //查询所有用户，同时查询每个用户关联的订单信息
    List<User> findAll();

    //查询所有用户，同时查询每个用户关联的角色信息
    List<User> findAllUserAndRole();

}
