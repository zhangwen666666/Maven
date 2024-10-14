package com.bjpowernode.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: DemoServlet
 * Description:
 * Datetime: 2024/3/21 9:56
 * Author: 张阿荣@动力节点
 * Version: 1.0
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

    /**
     * 客户端 :  <a href="/demo">访问服器</a>
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务器被访问到了..............new");
        req.getRequestDispatcher("/main.jsp").forward(req,resp);

    }
}
