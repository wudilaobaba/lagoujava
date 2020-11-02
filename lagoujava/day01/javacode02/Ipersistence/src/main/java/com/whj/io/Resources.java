package com.whj.io;

import java.io.InputStream;

public class Resources {
    /**
     * 根据配置文件的路径，将配置文件加载成字节输入流，存储在内存中
     * @param path 配置文件的路径
     * @return
     */
    public static InputStream getResourceAsStream(String path){
        //本类中使用：
        //本类.class.getClassLoader().getResourceAsStream(path);//将一个路径加载成字节流
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }
}
