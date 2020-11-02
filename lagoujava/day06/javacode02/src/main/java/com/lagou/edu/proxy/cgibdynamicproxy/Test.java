package com.lagou.edu.proxy.cgibdynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 测试cjlib代理对象
 */
public class Test {
    public static void main(String[] args) {
        RentingHouseImpl iRentingHouse = new RentingHouseImpl();//委托方

        //获取代理对象
        RentingHouseImpl rentingHouseProxy = (RentingHouseImpl) Enhancer.create(
                iRentingHouse.getClass(),
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        Object result = null;
                        System.out.println("增强一下下/....");
                        result = method.invoke(iRentingHouse, objects); //objects就是method的参数
                        System.out.println("又增强一下下/....");
                        return result;
                    }
                });

        String str = rentingHouseProxy.say();
        System.out.println(str);
    }

}
