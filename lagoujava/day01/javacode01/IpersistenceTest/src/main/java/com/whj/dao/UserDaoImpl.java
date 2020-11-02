package com.whj.dao;

import com.whj.io.Resources;
import com.whj.pojo.User;
import com.whj.sqlSession.SqlSession;
import com.whj.sqlSession.SqlSessionFactory;
import com.whj.sqlSession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements IUserDao{
    public List<User> findAll() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("user.selectList");
        return userList;
    }

    public User findByCondition(User user) throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User result = sqlSession.selectOne("user.selectOne", user);
        return result;
    }
}
