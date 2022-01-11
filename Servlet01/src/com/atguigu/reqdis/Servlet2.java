package com.atguigu.reqdis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChanceZhou
 * @create 2021-10-30-15:12
 */
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        System.out.println("Servlet2中查看参数" + username);

        //查看是否有章
        Object key1 = req.getAttribute("key1");
        System.out.println("柜台1是否有章" + key1);

        //处理自己的业务
        System.out.println("Servlet2的业务逻辑");


    }
}
