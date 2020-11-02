package com.lagou.edu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 横切逻辑
 */
public class LogUtils {
    /**
     * 方法执行前
     */
    public void beforeMEthod(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);//执行切入点的时候，会将切入点的参数进行打印
        }
        System.out.println("业务逻辑开始执行之前....");
    }
    /**
     * 方法结束时(无论异常与否都执行)
     */
    public void afterMEthod(){
        System.out.println("业务逻辑结束时执行（无论异常与否都执行）....");
    }

    /**
     * 异常时执行
     */
    public void exceptionMethod(){
        System.out.println("业务逻辑异常时执行....");
    }

    /**
     * 方法正常时执行
     * 参数是原方法的返回值
     */
    public void successMethod(Object retValue){
        System.out.println("业务逻辑正常时执行....");
    }

    /**
     * 环绕通知 *（不要和其他通知一起使用）
     * @param proceedingJoinPoint 原方法中的参数
     * @return
     * @throws Throwable
     */
    public Object arroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知中的beforeMethod");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());//控制切入点(原有业务逻辑)是否执行 ，这句话相当于method.incoke
            System.out.println("环绕通知中的aop:after-returning");
        }catch (Exception e){
            System.out.println("环绕通知中的aop:after-throwing");
        } finally {
            System.out.println("环绕通知中的aop:after");
        }
        return result;
    }
}
