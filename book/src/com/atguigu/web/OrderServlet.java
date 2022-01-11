package com.atguigu.web;

import com.atguigu.dao.impl.BaseDao;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChanceZhou
 * @create 2021-12-07-14:40
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            //后续代码不需执行 所以return
            return;
        }

        Integer userId = user.getId();
        String orderId = orderService.createOrder(cart, userId);
//        req.setAttribute("orderId", orderId);
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
//防止表单重复提交
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
