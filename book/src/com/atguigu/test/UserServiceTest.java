package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ChanceZhou
 * @create 2021-11-06-9:23
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "adminService1", "adminService1", "adminService1@163.com"));
        userService.registerUser(new User(null, "adminService2", "adminService2", "adminService2@163.com"));
    }

    @Test
    public void loginUser() {
//        System.out.println(userService.loginUser(new User(null, "1", "1", null)));
        System.out.println(userService.loginUser(new User(null, "adminService1", "adminService1", null)));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("adminService1")){
            System.out.println("已存在");
        }else {
            System.out.println("可用");

        }

    }
}