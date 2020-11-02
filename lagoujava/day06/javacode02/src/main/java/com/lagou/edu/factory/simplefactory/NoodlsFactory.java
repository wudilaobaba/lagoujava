package com.lagou.edu.factory.simplefactory;

import com.lagou.edu.factory.simplefactory.noodles.INoodles;
import com.lagou.edu.factory.simplefactory.noodles.LanZhouNoodles;
import com.lagou.edu.factory.simplefactory.noodles.PaoNoodles;

public class NoodlsFactory {
    /**
     * 静态方法创建的类就叫做静态工厂模式
     * @param type
     * @return
     */
    public static INoodles createNoodles(Integer type){
        INoodles iNoodles = null;
        switch (type){
            case 1:
                iNoodles = new PaoNoodles();
                break;
            case 2:
                iNoodles = new LanZhouNoodles();
                break;
            default:
                throw new RuntimeException("没有这种面");
        }
        return iNoodles;
    }
}
