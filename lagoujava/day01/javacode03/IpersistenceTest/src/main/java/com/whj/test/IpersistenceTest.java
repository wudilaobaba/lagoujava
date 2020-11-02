package com.whj.test;

import com.whj.dao.UserMapper;
import com.whj.io.Resources;
import com.whj.pojo.User;
import com.whj.sqlSession.SqlSession;
import com.whj.sqlSession.SqlSessionFactory;
import com.whj.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 测试方法
 */
public class IpersistenceTest {
    private SqlSession sqlSession;
    private UserMapper userMapper;
    @Before
    public void b() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(inputStream);
        this.sqlSession = sqlSessionFactory.openSession();
        this.userMapper = this.sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void test() throws Exception {
        User user = new User();
        user.setId(9);
        user.setPassword("password2");
        user.setUsername("HKS11");
        this.userMapper.updateOne(user);
    }

    @Test
    public void test1() throws Exception {
        List<User> users = this.userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test2(){
        User user = new User();
        user.setId(14);
        this.userMapper.delUser(user);
    }
}
