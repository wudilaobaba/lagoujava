package com.whj.test;

import com.whj.dao.IUserDao;
import com.whj.dao.UserDaoImpl;
import com.whj.io.Resources;
import com.whj.pojo.User;
import com.whj.sqlSession.SqlSession;
import com.whj.sqlSession.SqlSessionFactory;
import com.whj.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 测试方法
 */
public class IpersistenceTest {
    @Test
    public void test() throws Exception {
        // ============= 第一版 =================
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(resourceAsStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        User user = new User();
//        user.setId(1);
//        user.setUsername("lucy");
////        User user2 = sqlSession.selectOne("user.selectOne", user);
////        System.out.println(user2);
//
//        List<User> userList = sqlSession.selectList("user.selectList");
//        System.out.println(userList);


// ============= 第二版 =================
//        IUserDao dao = new UserDaoImpl();
//
//        //查询所有
//        System.out.println(dao.findAll());
//
//        //查询单个
//        User user = new User();
//        user.setId(1);
//        user.setUsername("lucy");
//        System.out.println(dao.findByCondition(user));



// ============= 最终版 请删掉UserDaoImpl =================
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);//1.返回代理对象

        List<User> userList = userDao.findAll();//2.代理对象执行接口中的任一方法，都会去执行getMapper中的invoke方法
        System.out.println(userList);

        User user = new User();
        user.setId(1);
        user.setUsername("lucy");
        User user1 = userDao.findByCondition(user);
        System.out.println(user1);

    }

    @Test
    /**
     * 使用反射获取字段值
     */
    public void testMySelf() throws Exception {
        User user = new User();
        user.setUsername("Whj");
        user.setId(11);
        user.setPassword("123456789");

        Field declaredField = User.class.getDeclaredField("password");
        declaredField.setAccessible(true);
        Object o = declaredField.get(user);
        System.out.println(o);//"123456789"
    }

    /**
     * 学习反射
     * 使用反射进行对象赋值
     */
    @Test
    public void fs() throws Exception {
        List<String> name = new ArrayList<String>();
        name.add("id");
        name.add("username");
        name.add("birthday");
        List<Object> value = new ArrayList<Object>();
        value.add(1);
        value.add("WW");
        value.add("2020-01-01");

        Object o = User.class.newInstance();//User类的实体

        for (int i=0;i<name.size();i++) {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(name.get(i), User.class);
            Method writeMethod = propertyDescriptor.getWriteMethod();
            writeMethod.invoke(o,value.get(i));
        }
        System.out.println((User)o);
    }
}
