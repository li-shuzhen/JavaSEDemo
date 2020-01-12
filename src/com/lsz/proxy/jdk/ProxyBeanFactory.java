package com.lsz.proxy.jdk;

/**
 * @description: 代理bean工厂类
 * @author: Lishuzhen
 * @create: 2020-01-12 19:31
 */
public class ProxyBeanFactory {

    public static <T> T getBean(T obj,MyInterceptor myInterceptor){
        return (T) ProxyBeanUtils.getBean(obj, myInterceptor);
    }
}
