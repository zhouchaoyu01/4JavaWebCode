package com.atguigu.utils;

import javax.servlet.http.Cookie;

/**
 * @author ChanceZhou
 * @create 2021-11-23-9:27
 */
public class CookieUtils {

    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

}
