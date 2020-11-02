package com.whj.mapper;

import com.whj.pojo.Order;
import com.whj.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrderMapper {
    void insertUser(User user);

    //查询订单的同时，查询该订单所属的用户 : 一对一
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "orderTime",column = "ordertime"),
            @Result(property = "total",column = "total"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "user",column = "uid",javaType = User.class,
                    one = @One(select="com.whj.mapper.IUserMapper.findUserById"))
    })
    @Select("select * from orders")
    List<Order> findOrderAndUser();

    @Select("select * from orders where uid = #{ui}")
    List<Order> findOrderByUid(Integer uid);






}
