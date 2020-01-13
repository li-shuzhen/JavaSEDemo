package com.lsz.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 通过 JDK动态代理 模拟实现AOP拦截器 执行流程
 * @author: Lishuzhen
 * @create: 2020-01-12 19:13
 */
public class ProxyBeanUtils implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object object;

    /**
     * 拦截器
     */
    private MyInterceptor myInterceptor = null;


    /**
     * 获取动态代理对象
     * @param object 被代理对象
     * @param myInterceptor 拦截器
     * @return
     */
    public static Object getBean(Object object, MyInterceptor myInterceptor){

        // 使用当前类，作为代理方法，此时被被代理对象执行方法的时候，会进入当前类的invoke方法
        ProxyBeanUtils _this = new ProxyBeanUtils();
        // 保存代理对象
        _this.object = object;
        // 保存拦截器
        _this.myInterceptor = myInterceptor;
        // 生成代理对象并绑定代理方法
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                _this);
    }

    /**
     * 代理方法
     * @param proxy 代理对象
     * @param method 代理方法
     * @param objects 参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {

        Object result = null;

        // 异常标识
        boolean exceptionFlag = false;

        myInterceptor.before(this.object);

        try{
            /**
             * 注意：invoke 方法中的参数是 被代理对象 而不是代理对象
             *  如果此处传参传入代理对象时，会陷入死循环，并抛出
             *  java.lang.reflect.InvocationTargetException
             */
            result = method.invoke(this.object, objects);
        }catch (Exception e){
            exceptionFlag = true;
        }finally {
            myInterceptor.after(this.object);
        }

        if(exceptionFlag){
            myInterceptor.afterThrowing(this.object);
        }else {
            myInterceptor.afterRunning(this.object);
        }
        return result;
    }
}
