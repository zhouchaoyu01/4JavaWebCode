package com.atguigu.resp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ChanceZhou
 * @create 2021-11-02-10:52
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(resp.getCharacterEncoding());
        //设置服务器字符集为UTF-8
        resp.setCharacterEncoding("UTF-8");

        //通过响应头，设置浏览器用utf-8
        resp.setHeader("Content-type", "text/html; charset=UTF-8");
        //or
//        resp.setContentType("text/html; charset=UTF-8");
        //往客户端回传 字符串 数据
        PrintWriter writer = resp.getWriter();
        writer.write("字符串 响应");
//        resp.getOutputStream();
    }
}
