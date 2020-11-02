package com.whj.test;

import com.whj.mapper.IOrderMapper;
import com.whj.mapper.IRoleMapper;
import com.whj.mapper.IUserMapper;
import com.whj.pojo.Order;
import com.whj.pojo.Role;
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

public class TestMybatis {
    private IUserMapper iUserMapper;
    private IOrderMapper orderMapper;
    private IRoleMapper roleMapper;
    private SqlSession sqlSession;
    @Before
    public void befor() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSession = sqlSessionFactory.openSession();
        this.iUserMapper = this.sqlSession.getMapper(IUserMapper.class);
        this.orderMapper = this.sqlSession.getMapper(IOrderMapper.class);
        this.roleMapper = this.sqlSession.getMapper(IRoleMapper.class);
    }



//    @Test
    /**
     * 注解 CURD
     */
//    public void test01() throws Exception {
//        User user = new User(15,"Hustons","sdsada","1999-08-09");
//        this.iUserMapper.addUser(user);
//        this.sqlSession.commit();
//    }

    /**
     * 一对一查询
     */
    @Test
    public void test02(){
        List<Order> orders = this.orderMapper.findOrderAndUser();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    /**
     * 一对多查询
     */
    @Test
    public void test03(){
        List<User> users = this.iUserMapper.fundUserWithOrders();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 多对多查询 fundUserWithRoles
     */
    @Test
    public void test04(){
        List<User> users = this.iUserMapper.fundUserWithRoles();
        for (User user : users) {
            System.out.println(user);
        }
    }



}
