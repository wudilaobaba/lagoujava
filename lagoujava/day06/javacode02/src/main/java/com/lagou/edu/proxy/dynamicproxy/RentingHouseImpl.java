package com.lagou.edu.proxy.dynamicproxy;

/**
 * 委托方
 */
public class RentingHouseImpl implements IRentingHouse{
    @Override
    public void rentHouse() {
        System.out.println("我要租房子");
    }

    @Override
    public String say() {
        return "说说说说说说说说...";
    }
}
