package com.lagou.edu.factory.simpleFactory2;

import com.lagou.edu.factory.simpleFactory2.factory.INoodleFactory;
import com.lagou.edu.factory.simpleFactory2.noodles.INoodles;

public class Test {
    public static void main(String[] args) {
        INoodleFactory iNoodleFactory = NoodFactoryBuilder.createFactory(2);
        INoodles iNoodles = iNoodleFactory.createINoodles();
        iNoodles.desc();
    }
}
