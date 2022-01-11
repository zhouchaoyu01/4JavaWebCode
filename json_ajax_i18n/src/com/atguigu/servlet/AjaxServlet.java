package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChanceZhou
 * @create 2021-12-18-8:45
 */
public class AjaxServlet extends BaseServlet {
    /**
     * 原生ajax
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajax请求");
        Person person = new Person(1, "zcy");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

    /**
     * jquery ajax
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void jqueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryAjax请求");
        Person person = new Person(1, "zcy");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

    /**
     * jqueryGet
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void jqueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryGet请求");
        Person person = new Person(1, "zcy");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

    /**
     * jqueryPost
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void jqueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryPost请求");
        Person person = new Person(1, "zcy");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

    /**
     * jqueryGetJSON
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void jqueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jqueryGetJSON请求");
        Person person = new Person(1, "zcy");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }

    protected void jquerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jquerySerialize请求");
        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("password"));
        Person person = new Person(1, "zcy");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        resp.getWriter().write(s);
    }


}
