package com.lagou.edu.proxy.dynamicproxyfactory;

public class Test {
    public static void main(String[] args) {
        IRetingHouse retingHouse = new RetingHouseImpl();//代理方
        IRetingHouse jdkProxy = (IRetingHouse)ProxyFactory.getInstance().getJdkProxy(retingHouse);//由工厂创建代理对象
        jdkProxy.rentHouse();//由代理对象来执行代理方的方法
    }
}
