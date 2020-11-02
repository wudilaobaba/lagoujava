package com.whj.mapper;

import com.whj.pojo.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.mybatis.caches.redis.RedisCache;

import java.util.List;
@CacheNamespace(implementation = RedisCache.class)//开启二级缓存
public interface UserMapper {
    @Select("select * from user")
    List<User> getAllUsers();

    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);

    @Update("update user set username = #{username} where id = #{id}")
    void updateUser(User user);
}
