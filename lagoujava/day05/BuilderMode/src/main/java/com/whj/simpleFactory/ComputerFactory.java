package com.whj.simpleFactory;

public class ComputerFactory {
    public static Computer createComputer(String type){
        Computer computer = null;
        switch (type){
            case "Lx":
                computer = new LxComputer();
                break;
            case "Hp":
                computer = new HpComputer();
                break;
        }
        return computer;
    }
}
