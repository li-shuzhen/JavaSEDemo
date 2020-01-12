package com.lsz.proxy.jdk;

/**
 * @description: 拦截器接口
 * @author: Lishuzhen
 * @create: 2020-01-12 19:08
 */
public interface MyInterceptor {

    /**
     * 前置方法
     * @param obj
     */
    void before(Object obj);

    /**
     * 后置方法
     * @param obj
     */
    void after(Object obj);

    /**
     * 正常运行后置方法
     * @param obj
     */
    void afterRunning(Object obj);

    /**
     * 异常后置方法
     * @param obj
     */
    void afterThrowing(Object obj);
}
