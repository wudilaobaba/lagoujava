package com.whj.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;
@Intercepts({
    @Signature(
        type = StatementHandler.class,//sql语句的预处理核心对象
        method = "prepare",//拦截StatementHandler中的prepare方法
        args = {Connection.class, Integer.class}//prepare方法的参数类型
    )
})
public class MyPlugin implements Interceptor {
    /**
     * 执行prepare （执行sql语句的之前） ，就会执行该方法
     * 拦截方法，只要被拦截的目标对象的目标方法被执行时。每次都会执行该方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("对方法进行了增强。。。");
        //可以进行分页等操作
        return invocation.proceed();//原方法执行
    }

    /**
     * 先执行
     * 主要为了把当前类生成代理存到拦截器链中
     * @param
     * @return
     */
    @Override
    public Object plugin(Object target) {//被拦截的目标对象
        System.out.println("44545");
        Object wrap = Plugin.wrap(target, this);
        return wrap;
    }

    /**
     * 获取配置文件的参数
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("获取到的配置文件参数是："+properties);
    }
}
