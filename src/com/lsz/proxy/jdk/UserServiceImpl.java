package com.lsz.proxy.jdk;

/**
 * @description:
 * @author: Lishuzhen
 * @create: 2020-01-12 19:02
 */
public class UserServiceImpl implements UserService {
    /**
     * 输出user信息
     *
     * @param user
     */
    @Override
    public void printUser(User user) {
        System.out.println(1111111);
//        System.out.println(user);
    }
}
