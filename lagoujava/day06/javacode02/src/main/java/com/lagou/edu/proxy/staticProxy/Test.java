package com.lagou.edu.proxy.staticProxy;


public class Test {
    public static void main(String[] args) {
        /** 测试静态代理 */
        IRentingHouse iRentingHouse = new RentingHouseImpl();
        RetingHouseProxy retingHouseProxy = new RetingHouseProxy(iRentingHouse);
        retingHouseProxy.rentHouse();//代理实现类去执行并增强iRentingHouse的rentHouse方法
    }
}
