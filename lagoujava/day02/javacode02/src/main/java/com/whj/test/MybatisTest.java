package com.whj.test;

import com.whj.dao.IUserDao;
import com.whj.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test01() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //生成代理对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);

        List<User> users = mapper.findAll();
        System.out.println(users);

        User user = mapper.findById(1);
        System.out.println(user);
    }

}
