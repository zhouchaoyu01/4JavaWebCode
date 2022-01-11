package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChanceZhou
 * @create 2021-11-06-15:26
 */
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService.loginUser(new User(null, username, password, null)) == null) {
//            System.out.println("用户名或者密码错误！");
            //把错误信息和回显的表单项信息，保存带request域中
            req.setAttribute("msg" ,"用户名或者密码错误");
            req.setAttribute("username" , username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            System.out.println("登录成功");
            req.getRequestDispatcher("/pages/user/loginSuccess.jsp").forward(req, resp);
        }


    }
}
