package com.lagou.edu.proxy.staticProxy;

public class RetingHouseProxy implements IRentingHouse{
    private IRentingHouse rentingHouse;
    public RetingHouseProxy(IRentingHouse rentingHouse){
        this.rentingHouse = rentingHouse;
    }
    @Override
    public void rentHouse() {
        System.out.println("111");
        this.rentingHouse.rentHouse();
        System.out.println("222");
    }
}
