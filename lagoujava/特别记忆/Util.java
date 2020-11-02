package com.whj.util;

import java.lang.reflect.Field;

public class Util {
    /**
     * 根据实例以及字段名，获取该实例该字段的值 当实例没有geter方法时，也生效
     * @param obj 实例对象
     * @param fileName 字段名
     * @return 实例该字段的值
     * @throws Exception
     */
    public static Object getFileValue(Object obj,String fileName) throws Exception {
        Class<?> cls = obj.getClass();
        Field declaredField = cls.getDeclaredField(fileName);
        declaredField.setAccessible(true);
        Object fileVal = declaredField.get(obj);
        return fileVal;
    }
}
