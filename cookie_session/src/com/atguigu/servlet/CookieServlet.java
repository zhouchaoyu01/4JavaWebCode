package com.atguigu.servlet;

import com.atguigu.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChanceZhou
 * @create 2021-11-23-8:46
 */
public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.
        Cookie cookie = new Cookie("key1", "value1");
        //2.
        resp.addCookie(cookie);
        //1.
        Cookie cookie1 = new Cookie("key2", "value2");
        //2.
        resp.addCookie(cookie1);


        resp.getWriter().write("cookies创建成功");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {

            resp.getWriter().write("cookie[" + cookie.getName() + "=" + cookie.getValue() + "]</br>");
        }

        Cookie wanted = CookieUtils.findCookie("key1", cookies);


//        for (Cookie cookie : cookies) {
//            if ("key2".equals(cookie.getName())) {
//                wanted = cookie;
//                break;
//            }
//        }
        if (wanted != null) {
            resp.getWriter().write("找到了需要的cookie");
        }

    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //不支持中文 需修改编码 见文件上传下载
        //方案一
        Cookie cookie = new Cookie("key1", "newValue1");
        resp.addCookie(cookie);
        resp.getWriter().write("cookie1修改成功");
        //方案二
        Cookie cookie1 = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie1 != null) {
            cookie1.setValue("newValue2");
            resp.addCookie(cookie1);

        }
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(0);//设置存活时间
            resp.addCookie(cookie);
        }
    }

    protected void setTime(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(3600);//设置存活时间
            resp.addCookie(cookie);
        }
    }

    protected void setPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie cookie = new Cookie("path1", "path1");
        cookie.setPath(req.getContextPath() + "/abc");//=>/工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有工程路径/abc的cookie");
    }
}

