package com.lagou.edu.singleton;

/**
 * 饿汉式 立即加载 jvm一加载就就实例化
 * 使用 Hungry.getInstance()
 */
public class Hungry {
    /** 构造方法私有化 */
    private Hungry(){

    }

    /** 将自身实例化对象设置为一个属性，并用static，final修饰 */
    private static final Hungry instance = new Hungry();

    /** 静态方法返回该实例 */
    public static Hungry getInstance(){
        return instance;
    }
}
