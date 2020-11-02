package com.whj.test;

import com.whj.mapper.UserMapper;
import com.whj.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestWhj {
    private SqlSession sqlSession;
    private UserMapper userMapper;
    @Before
    public void test() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        this.userMapper = this.sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void test01(){
        List<User> users = this.userMapper.getAllUsers();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getOrders());
        }
    }
}
