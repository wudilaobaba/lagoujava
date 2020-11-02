package com.lagou.edu.proxy.dynamicproxyfactory;

public class RetingHouseImpl implements IRetingHouse{
    @Override
    public void rentHouse() {
        System.out.println("来租房子了");
    }

    @Override
    public String say() {
        return "66666";
    }
}
