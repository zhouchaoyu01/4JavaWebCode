package com.atguigu.resp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChanceZhou
 * @create 2021-11-04-10:04
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("resp1 到此一游");
//方式一
        //302 重定向
//        resp.setStatus(302);
//        //设置响应头 说明新地址
//        resp.setHeader("location", "http://localhost:8080/Servlet02/response2");

        //方式二
        resp.sendRedirect("http://localhost:8080/Servlet02/response2");
    }
}
