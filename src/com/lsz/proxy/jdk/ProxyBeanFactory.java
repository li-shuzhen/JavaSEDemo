package com.lsz.proxy.jdk;

/**
 * @description: 代理bean工厂类
 * @author: Lishuzhen
 * @create: 2020-01-12 19:31
 */
public class ProxyBeanFactory {

    public static <T> T getBean(T obj,MyInterceptor myInterceptor){
        T result = (T) ProxyBeanUtils.getBean(obj, myInterceptor);
        System.out.println("ProxyBeanFactory.getBean" + result);
        return result;
    }

//    public static UserService getBean(Object obj,MyInterceptor myInterceptor){
//        return (UserService)ProxyBeanUtils.getBean(obj, myInterceptor);
//    }
}
