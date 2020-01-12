package com.lsz.proxy.jdk;

/**
 * @description: 测试类
 * @author: Lishuzhen
 * @create: 2020-01-12 19:29
 */
public class TestMain {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        MyInterceptor myInterceptor = new UserInterceptor();

        UserService proxy = ProxyBeanFactory.getBean(userService, myInterceptor);
//        UserService proxy = (UserService) ProxyBeanUtils.getBean(userService, myInterceptor);
        System.out.println(proxy);

//        User user = new User("张三", 18);
//
//        proxy.printUser(user);
//        System.out.println(user);
    }

}
