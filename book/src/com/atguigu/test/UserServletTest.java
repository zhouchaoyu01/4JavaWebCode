package com.atguigu.test;

import com.atguigu.web.UserServlet;

import java.lang.reflect.Method;

/**
 * @author ChanceZhou
 * @create 2021-11-16-19:35
 */
public class UserServletTest {

    public void login() {
        System.out.println("调用login方法");
    }

    public void regist() {
        System.out.println("调用regist方法");
    }

    public void updateUser() {
        System.out.println("调用updateUser方法");
    }

    public void updatePassword() {
        System.out.println("调用updatePassword方法");
    }

    public static void main(String[] args) {
        String action = "updatePassword";

        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);

            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
