package com.whj.proxy;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@AllArgsConstructor
public class JdkDynamic implements InvocationHandler {
    //声明被代理的对象
    private Person person;

    //获取代理对象
    public Object getTarget(){
        Object proxyInstance = Proxy.newProxyInstance(this.person.getClass().getClassLoader(), this.person.getClass().getInterfaces(), this);
        return proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //原方法执行之前：
        System.out.println("原方法执行之前...");
        //执行原方法：
        Object invoke = method.invoke(this.person, args);
        //原方法执行之后：
        System.out.println("原方法执行之后...");
        return invoke;
    }
}
