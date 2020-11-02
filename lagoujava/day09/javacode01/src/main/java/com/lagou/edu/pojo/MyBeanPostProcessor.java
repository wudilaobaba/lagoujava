package com.lagou.edu.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 拦截实例化之后的对象(实例化了并且属性注入了) 对照day08中的看
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor(){
        System.out.println("构造函数");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("lazyResult".equalsIgnoreCase(beanName)){
            System.out.println("BeanPostProcessor实现类的postProcessBeforeInitialization方法调用中...");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("lazyResult".equalsIgnoreCase(beanName)){
            System.out.println("BeanPostProcessor实现类的postProcessAfterInitialization方法调用中...");
        }
        return bean;
    }
}
