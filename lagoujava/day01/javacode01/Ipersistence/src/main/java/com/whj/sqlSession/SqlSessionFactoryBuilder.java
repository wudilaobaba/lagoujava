package com.whj.sqlSession;

import com.whj.config.XMLConfigBuilder;
import com.whj.pojo.Configuration;
import org.dom4j.DocumentException;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    /**
     * @param in 数据库配置文件
     * @return
     * @throws Exception
     */
    public static SqlSessionFactory build(InputStream in) throws Exception {
        //1.使用dom4j解析配置文件in,将数据封装到Configuration中
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        //处理好的最终的Configuration对象(包含了数据库连接池信息，和sql信息)
        Configuration configuration = xmlConfigBuilder.parseConfig(in);

        //2.创建SqlSessionFactory对象，用来生产SqlSession：与数据交互的增删改查方法
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        return defaultSqlSessionFactory;
    }
}
