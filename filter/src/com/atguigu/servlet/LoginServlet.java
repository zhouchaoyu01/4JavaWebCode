package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChanceZhou
 * @create 2021-12-08-20:43
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("abc".equals(username) && "123".equals(password)) {
            req.getSession().setAttribute("username", username);
            resp.getWriter().write("登录成功 ");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
