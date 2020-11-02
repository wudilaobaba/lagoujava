package com.lagou.edu.proxy.cgibdynamicproxy;

public class RentingHouseImpl{
    public void rentHouse() {
        System.out.println("cglib来租房子了");
    }

    public String say() {
        return "cglib来租房子了";
    }
}
