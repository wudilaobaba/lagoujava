package com.lagou.edu.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author 应癫
 */
public class Result implements BeanNameAware, BeanFactoryAware , ApplicationContextAware, InitializingBean, DisposableBean {
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("管理我的beanFactory: "+beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("注册我成为bean时定义的id: "+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("高级接口: "+applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet方法");
    }

    public void initMethod(){
        System.out.println("init-method");
    }

    @PostConstruct //类似与initMethod，可以替代nit-method"
    public void postConstruct(){
        System.out.println("postConstruct");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁(继承的接口方法)");
    }

//    @PreDestroy//销毁方法
//    public void destroy(){
//        System.out.println("销毁了.....");
//    }
}
