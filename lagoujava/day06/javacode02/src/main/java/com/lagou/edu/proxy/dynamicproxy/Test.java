package com.lagou.edu.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        IRentingHouse rentingHouse = new RentingHouseImpl();//委托方
        //获取代理对象，代理对象的类型与委托方类型保持一致
        IRentingHouse proxy = (IRentingHouse)Proxy.newProxyInstance( //代理对象proxy在底层自动生成
                rentingHouse.getClass().getClassLoader(),//代理对象的类
                rentingHouse.getClass().getInterfaces(),//代理对象实现的接口
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
                        result = method.invoke(rentingHouse,args);//调用原有业务逻辑
                        System.out.println(method.toString());
                        return result;
                    }
                }
        );
        String a = proxy.say();//以后只要代理对象调用原方法就可实现业务增强
        System.out.println(a);
    }
}
