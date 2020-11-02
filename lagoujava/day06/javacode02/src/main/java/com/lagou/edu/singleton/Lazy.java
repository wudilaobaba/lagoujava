package com.lagou.edu.singleton;

public class Lazy {
    /** 构造方法私有化 */
    private Lazy(){

    }
    /** 将自身实例化对象设置为一个属性，并用static修饰 */
    private static Lazy instance;

    /** 静态方法返回该实例，将关键字实现同步 */
    public static synchronized Lazy getInstance(){//保证线程安全
        if (instance == null){
            instance = new Lazy();
        }
        return instance;
    }
}
