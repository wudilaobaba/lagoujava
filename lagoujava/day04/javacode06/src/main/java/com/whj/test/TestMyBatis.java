package com.whj.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whj.mapper.UserMapper;
import com.whj.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;

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
        this.userMapper = this.sqlSession.getMapper(UserMapper.class);
    }

    /**
     * 测试Mybatis中使用第三方插件 :pageHelper分页插件
     */
    @Test
    public void test01(){
        User user = new User(12,"Mike","123","1988-11-09");
        User user1 = this.userMapper.selectOne(user);
        System.out.println(user1);

        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id",12);//自定义条件查询
        List<User> users = this.userMapper.selectByExample(example);
        for (User user2 : users) {
            System.out.println(user2);
        }
    }
}
