package com.gitweb.shop.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 添加商品
 */
@WebServlet(name = "addGoods",urlPatterns = "/addGoods")
public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //替换servletName值，起到切换页面内容的效果
        session.setAttribute("servletName","addGoods");
        req.getRequestDispatcher("/content.jsp").forward(req,resp);
    }
}
