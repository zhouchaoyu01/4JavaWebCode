package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author ChanceZhou
 * @create 2021-11-14-10:58
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String downloadFileName = "default.jpg";

        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("下载的文件类型 " + mimeType);
        resp.setContentType(mimeType);

        if (req.getHeader("User-Agent").contains("Firefox")) {

            resp.setHeader("Content-Disposition", "attachment; fileName==?UTF-8?B?" + new BASE64Encoder().encode("中国.jpg".getBytes(StandardCharsets.UTF_8)) + "?=");
        } else {

            resp.setHeader("Content-Disposition", "attachment; fileName=" + URLEncoder.encode("中国.jpg", "UTF-8"));
        }


        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        OutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);

    }
}
