package com.whj.constructor;

import org.junit.Test;

/**
 * 构建者模式测试类
 */
public class ConstructorTest {
    @Test
    public void test(){
        ComputerBuilder computerBuilder = new ComputerBuilder();
        computerBuilder.installDisplayer("显示器");
        computerBuilder.installKeyboard("键盘");
        computerBuilder.installMainUnit("主机");
        computerBuilder.installMouse("鼠标");
        Computer computer = computerBuilder.getComputer();
        System.out.println(computer);
    }
}

