package com.whj.simpleFactory;

import org.junit.Test;

public class SimpleFactoryTest {
    @Test
    public void test(){
        Computer computer1 = ComputerFactory.createComputer("Hp");
        Computer computer2 = ComputerFactory.createComputer("Lx");
        computer1.start();
        computer2.start();
    }
}
