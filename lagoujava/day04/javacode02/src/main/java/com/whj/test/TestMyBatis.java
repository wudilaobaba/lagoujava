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
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    /**
     * 测试Mybatis二级缓存
     */
    @Test
    public void test01(){
        SqlSession sqlSession1 = this.sqlSessionFactory.openSession();
        SqlSession sqlSession2 = this.sqlSessionFactory.openSession();
        SqlSession sqlSession3 = this.sqlSessionFactory.openSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
        User user1 = mapper1.findUserById(12);
        sqlSession1.close();//清空一级缓存

        User user = new User(12,"MMM","","");
        mapper3.updateUser(user);
        sqlSession3.commit();//提交事务后，二级缓存会被清空

        User user2 = mapper2.findUserById(12);//执行的是操作数据库

        System.out.println(user1 == user2);
    }

}
