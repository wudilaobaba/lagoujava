package com.whj.proxy;

import org.junit.Test;

public class ProxyTest {
    @Test
    public void test(){
        Person bob = (Person)new JdkDynamic(new Bob()).getTarget();
        bob.doSomething();
    }
}
