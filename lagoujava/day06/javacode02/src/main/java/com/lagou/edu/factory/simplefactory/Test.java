package com.lagou.edu.factory.simplefactory;

import com.lagou.edu.factory.simplefactory.noodles.INoodles;
import com.lagou.edu.factory.simplefactory.noodles.PaoNoodles;

public class Test {
    public static void main(String[] args) {
        INoodles pao = NoodlsFactory.createNoodles(2);
        pao.desc();
    }
}
