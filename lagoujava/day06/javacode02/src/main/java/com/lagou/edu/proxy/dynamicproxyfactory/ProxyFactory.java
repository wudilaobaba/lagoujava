package com.lagou.edu.proxy.dynamicproxyfactory;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象工厂，用来生产代理对象
 */
public class ProxyFactory {
    /** 饿汉 实现单例 */
    private ProxyFactory(){}
    private static ProxyFactory proxyFactory = new ProxyFactory();
    public static ProxyFactory getInstance(){
        return proxyFactory;
    }

    /**
     * 使用jdk动态代理
     * @param obj 委托方
     * @return 代理对象
     */
    public Object getJdkProxy(Object obj) {
        Object proxy = Proxy.newProxyInstance( //代理对象proxy在底层自动生成
                obj.getClass().getClassLoader(),//代理对象的类
                obj.getClass().getInterfaces(),//代理对象实现的接口
                new InvocationHandler() {//代理对象需要的横切逻辑是什么
                    @Override
                    /**
                     * @param method 代理方的原方法
                     * @param args 代理方的原方法中的参数
                     */
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        //原方法调用之前：
                        System.out.println("增强逻辑");
                        Object result = null;//method的返回值
                        //代理方调用rentHouse的时候，method就是rentHouse方法
                        //args是method方法的参数
                        //所以在这里调用method就是调用原有业务逻辑
                        result = method.invoke(obj,args);//调用原有业务逻辑
                        System.out.println(method.toString());
                        return result;
                    }
                }
        );
        return proxy;
    }
}
