package com.atguigu.reqdis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发
 *
 * @author ChanceZhou
 * @create 2021-10-30-15:11
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        System.out.println("Servlet1中查看参数" + username);

        //给参数盖章
        req.setAttribute("key1", "柜台1的章");

        //问路：Servlet2怎么走
      //web目录
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form.html");
        //走向Servlet2
        requestDispatcher.forward(req, resp);

    }
}
