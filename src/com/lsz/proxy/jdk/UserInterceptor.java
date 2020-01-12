package com.lsz.proxy.jdk;

/**
 * @description: 拦截器
 * @author: Lishuzhen
 * @create: 2020-01-12 19:05
 */
public class UserInterceptor implements MyInterceptor {
    /**
     * 前置方法
     *
     * @param obj
     */
    @Override
    public void before(Object obj) {
        System.out.println("*********** 准备执行 **************");
    }

    /**
     * 后置方法
     *
     * @param obj
     */
    @Override
    public void after(Object obj) {
        System.out.println("*********** 执行结束 **************");
    }

    /**
     * 正常运行后置方法
     *
     * @param obj
     */
    @Override
    public void afterRunning(Object obj) {
        System.out.println("*********** 正常执行结束 **************");
    }

    /**
     * 异常后置方法
     *
     * @param obj
     */
    @Override
    public void afterThrowing(Object obj) {
        System.out.println("*********** 执行过程中出现异常 **************");
    }
}
