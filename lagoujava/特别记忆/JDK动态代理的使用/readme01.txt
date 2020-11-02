package com.whj.tests;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Dynamic implements InvocationHandler {
    private Animal animal;//委托方(接口)
    public Dynamic(Animal animal){
        this.animal = animal;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //原方法执行之前：
        System.out.println("原方法执行之前...");
        //执行原方法：
        Object invoke = method.invoke(this.animal, args);
        //原方法执行之后：
        System.out.println("原方法执行之后...");
        return invoke;
    }

    // 返回Animal接口的实例
    public Object getTarget(){
        Object proxyInstance = Proxy.newProxyInstance(this.animal.getClass().getClassLoader(), this.animal.getClass().getInterfaces(), this);
        return proxyInstance;
    }

}

使用：
  Animal dog = (Animal)new JdkDynamic(new Dog()).getTarget();
  dog.doSomething();
