package com.whj.constructor;

public class ComputerBuilder {
    private Computer computer = new Computer();

    /**
     * 安装键盘
     * @param keyboard
     */
    public void installKeyboard(String keyboard){
        this.computer.setKeyboard(keyboard);
    }
    /**
     * 安装显示器
     * @param displayer
     */
    public void installDisplayer(String displayer){
        this.computer.setDisplayer(displayer);
    }
    /**
     * 安装主机
     * @param mainUnit
     */
    public void installMainUnit(String mainUnit){
        this.computer.setMainUnit(mainUnit);
    }
    /**
     * 安装鼠标
     * @param mouse
     */
    public void installMouse(String mouse){
        this.computer.setMouse(mouse);
    }

    public Computer getComputer(){
        return this.computer;
    }
}
