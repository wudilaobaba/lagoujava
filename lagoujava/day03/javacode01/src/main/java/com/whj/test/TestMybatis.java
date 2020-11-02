package com.whj.test;

import com.whj.mapper.IOrderDao;
import com.whj.mapper.IUserMapper;
import com.whj.pojo.Order;
import com.whj.pojo.User;
import com.whj.util.CommonUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    /**
     * 使用代码生成20条order数据
     */
    public void test01() throws Exception {
//        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        IOrderDao mapper = sqlSession.getMapper(IOrderDao.class);
//
//        for (int i = 0; i < 20; i++) {
//            String date = CommonUtil.randomTime("2015-12-15 00:00:00","2020-08-31 10:15:12");
//            double randomDouble = CommonUtil.randomTotal(15.22,111.11);
//            int uid = CommonUtil.randomUserId(9,13);
//            Order order = new Order(null,date,randomDouble,uid);
//            mapper.insertOrder(order);
//            sqlSession.commit();
//        }
    }

    @Test
    /**
     * 新增user
     */
    public void test02() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        User user = new User(13,"Like","!@saddddddd","2001-02-23");
        mapper.insertUser(user);
        sqlSession.commit();
    }

    @Test
    /**
     * 测试resultMap
     */
    public void test03() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        List<Order> orders = mapper.findOrderAndUser();
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i));
        }

    }
}
