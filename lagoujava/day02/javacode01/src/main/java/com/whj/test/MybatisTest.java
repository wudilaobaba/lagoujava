package com.whj.test;

import com.whj.dao.IUserDao;
import com.whj.dao.UserDaoImpl;
import com.whj.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test1() throws Exception {
        //1.工具类，生成字节文件流
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2.解析配置文件，并创建sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3.生产SqlSession
        //默认开启一个事务，但是不会自动提交，要自己在增删改的时候手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();//参数传true,则会自动提交
        //4.SqlSession调用方法
        List<User> users = sqlSession.selectList("user.findAll");
        System.out.println(users);

        sqlSession.close();
    }

    @Test
    public void testx() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User od = sqlSession.selectOne("user.findUserById", 1);
        System.out.println(od);
        sqlSession.close();
    }

    @Test
    public void test2() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        User user = new User();
        user.setUsername("John");
        user.setId(6);
        sqlSession.insert("user.saveUser",user);
//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("lll");
        user.setPassword("123456789+");
        user.setId(1);
        sqlSession.update("user.editUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("user.delUser",2);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试传统DAO层调用mybatis
     */
    @Test
    public void getAllUsers() throws Exception {
        IUserDao dao = new UserDaoImpl();
        List<User> users = dao.findAll();
        System.out.println(users);
    }

}
