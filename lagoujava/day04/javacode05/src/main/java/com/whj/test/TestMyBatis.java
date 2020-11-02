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
    public void test02(){
        PageHelper.startPage(1,2);
        List<User> users = this.userMapper.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        System.out.println(userPageInfo);
        //总条数：getTotal()
        //总页数：getPages()
        //当前页：getPageNum()
        //每页显示的条数：getPageSize()
    }
}
