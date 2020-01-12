package com.lsz.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: JDK 动态代理执行流程
 * @author: Lishuzhen
 * @create: 2020-01-12 19:13
 */
public class ProxyBeanUtils implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object object = null;

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
     * @param o 代理对象
     * @param method 代理方法
     * @param objects 参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        System.out.println("method"+method);
        System.out.println("objects"+objects);

        Object result = null;

        // 异常标识
        boolean exceptionFlag = false;

        // before 方法
//        myInterceptor.before(o);

        try{
            result = method.invoke(o, objects);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("******** 运行过程中发生异常 ************");
            exceptionFlag = true;
        }finally {
//            myInterceptor.after(o);
        }

        if(exceptionFlag){
//            myInterceptor.afterThrowing(o);
        }else {
//            myInterceptor.afterRunning(o);
        }
        return result;
    }
}
