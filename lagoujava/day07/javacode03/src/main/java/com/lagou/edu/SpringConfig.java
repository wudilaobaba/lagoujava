package com.lagou.edu;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration //表明当前类是一个配置类

/** 开启注解扫描(数组) */
@ComponentScan({"com.lagou.edu"})

/** 引入外部资源.properties文件 用于读取该文件中的内容: 如：${jdbc.url} */
@PropertySource("classpath:jdbc.properties")
//@Import()//把所有的配置类都import到这一个类中，加载的时候值启动这个类即可
public class SpringConfig {
    @Value("${jdbc.driver}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean("druidDataSource")//将该方法的返回值加入到容器
    public DataSource createDatasource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(this.driverClassName);
        druidDataSource.setUrl(this.url);
        druidDataSource.setUsername(this.username);
        druidDataSource.setPassword(this.password);
        return druidDataSource;
    }

}
