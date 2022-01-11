package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChanceZhou
 * @create 2021-11-21-10:31
 */
public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //经过了前台的ClientBookServlet程序
        System.out.println("经过了前台的ClientBookServlet程序");
        //1. 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
//        System.out.println(pageNo);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2. 调用bookService.page(pageNo,pageSize):Page
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        //3. 保存Page对象到request域
        req.setAttribute("page", page);
        //4. 请求转发到"/pages/client/index.jsp"
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    /**
     * 按照价格区间分页
     * 有bug 当输入一次后无法返回无价格搜索的界面
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //经过了前台的ClientBookServlet程序
//        System.out.println("经过了前台的ClientBookServlet程序");
        //1. 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
//        System.out.println(pageNo);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        //2. 调用bookService.page(pageNo,pageSize):Page
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder builder = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (req.getParameter("min") != null) {
            builder.append("&min=").append(req.getParameter("min"));

        }
        if (req.getParameter("max") != null) {
            builder.append("&max=").append(req.getParameter("max"));

        }

//        page.setUrl("client/bookServlet?action=pageByPrice");
        page.setUrl(builder.toString());


        //3. 保存Page对象到request域
        req.setAttribute("page", page);
        //4. 请求转发到"/pages/client/index.jsp"
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
