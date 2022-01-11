package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.test.UserServletTest;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author ChanceZhou
 * @create 2021-11-16-16:39
 */
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    /**
     * 登陆
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.loginUser(new User(null, username, password, null));
        if (user == null) {
//            System.out.println("用户名或者密码错误！");
            //把错误信息和回显的表单项信息，保存带request域中
            req.setAttribute("msg", "用户名或者密码错误");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            System.out.println("登录成功");
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 注册
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
//        System.out.println(username);
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        //   2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if (token != null && token.equalsIgnoreCase(code)) {
            //   3、检查 用户名是否可用
            if (userService.existsUsername(username)) {
                //不可
                System.out.println("用户名[" + username + "]已存在!");

                //把回显信息保存在request域中
                req.setAttribute("msg", "用户名已存在!");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                //        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //      可用
                //        调用Service保存到数据库
                userService.registerUser(new User(null, username, password, email));
                //
                //        跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }


        } else {
            //把回显信息保存在request域中
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            //验证码不正确
            //跳回注册页面
            System.out.println("验证码[" + code + "]不正确");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);

        }

    }

    /**
     *  注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());

    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//
//        //1.未优化 需要大量else if
//////        System.out.println(action);
////        if ("login".equals(action)) {
//////            System.out.println("处理登陆");
////            login(req, resp);
////
////        } else if ("regist".equals(action)) {
//////            System.out.println("处理注册");
////            regist(req, resp);
////        }
//
//        //2.利用反射获取
//        try {
//            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
//            System.out.println(method);
//
//            method.invoke(this, req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
//        System.out.println(username);
        boolean existsUsername = userService.existsUsername(username);
        Map<String , Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);

        Gson gson = new Gson();
        String s = gson.toJson(resultMap);
        resp.getWriter().write(s);
    }
}
