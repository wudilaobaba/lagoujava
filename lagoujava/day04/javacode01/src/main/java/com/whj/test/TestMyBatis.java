package com.whj.test;

import com.whj.mapper.UserMapper;
import com.whj.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void before() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSession = sqlSessionFactory.openSession();
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void test01(){
        //第一次查询id为9的用户
        User user1 = this.userMapper.findUserById(9);
        System.out.println(user1);

        //第二次查询id为9的用户
        User user2 = this.userMapper.findUserById(9);
        System.out.println(user2);

        System.out.println(user1 == user2);//地址相同
    }

    @Test
    public void test02(){
        //第一次查询id为9的用户
        User user1 = this.userMapper.findUserById(9);
        System.out.println(user1);

        //修改用户名
        User user = new User(9,"TP","","");
        this.userMapper.updateUser(user);
        this.sqlSession.commit();
        this.sqlSession.clearCache();//手动刷新一级缓存

        //第二次查询id为9的用户
        User user2 = this.userMapper.findUserById(9);
        System.out.println(user2);

        System.out.println(user1 == user2);//地址不相同了
    }
}
