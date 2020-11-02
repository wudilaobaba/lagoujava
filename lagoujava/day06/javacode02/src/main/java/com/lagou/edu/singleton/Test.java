package com.lagou.edu.singleton;

public class Test {
    public static void main(String[] args) {
        Hungry instance = Hungry.getInstance();//饿汉式
        Lazy instance1 = Lazy.getInstance();
    }
}
