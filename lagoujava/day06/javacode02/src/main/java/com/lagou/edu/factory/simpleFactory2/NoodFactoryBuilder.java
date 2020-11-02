package com.lagou.edu.factory.simpleFactory2;

import com.lagou.edu.factory.simpleFactory2.factory.INoodleFactory;
import com.lagou.edu.factory.simpleFactory2.factory.LanZhouFactory;
import com.lagou.edu.factory.simpleFactory2.factory.PaoFactory;

public class NoodFactoryBuilder {
    public static INoodleFactory createFactory(Integer type){
        switch (type){
            case 1:
                return new LanZhouFactory();
            case 2:
                return new PaoFactory();
        }
        throw new RuntimeException("沒有這種面");
    }
}
