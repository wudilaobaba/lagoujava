package com.lagou.edu.factory.simpleFactory2.factory;


import com.lagou.edu.factory.simpleFactory2.noodles.INoodles;
import com.lagou.edu.factory.simpleFactory2.noodles.LanZhouNoodles;

public class LanZhouFactory implements INoodleFactory{
    @Override
    public INoodles createINoodles() {
        return new LanZhouNoodles();
    }
}
