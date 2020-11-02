package com.whj.mapper;

import com.whj.pojo.Order;
import com.whj.pojo.Role;
import com.whj.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserMapper {
    //查询所有用户，同时查询每个用户关联的订单信息
    List<User> findAll();

    //查询所有用户，同时查询每个用户关联的角色信息
    List<User> findAllUserAndRole();

    //新增用户
    @Insert("insert into user values(#{id},#{username},#{birthday},#{password})")
    void addUser(User user);

    //更新用户
    @Update("update user set username = #{username} where id = #{id}")
    void uodateUser(User user);

    //查询用户
    @Select("select * from user")
    List<User> selectUser();

    //删除用户
    @Delete("delete from user where id = #{x}")
    void deleteUser(Integer id);

    //根据id查用户
    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);

    //查询用户的同时，查询该用户的所有订单 : 一对多
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "password",column = "password"),
            @Result(property = "orders",column = "id",javaType = List.class,
                many = @Many(select = "com.whj.mapper.IOrderMapper.findOrderByUid"))
    })
    @Select("select * from user")
    List<User> fundUserWithOrders();

    //查询用户的同时，查询该用户所属的角色 : 多对多
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "password",column = "password"),
            @Result(property = "roles",column = "id",javaType = List.class,
                    many = @Many(select = "com.whj.mapper.IRoleMapper.getRoleByUid"))
    })
    @Select("select * from user")
    List<User> fundUserWithRoles();
}
