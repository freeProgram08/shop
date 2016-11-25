package com.gitweb.shop.servlet;

import com.gitweb.shop.dao.IUserDao;
import com.gitweb.shop.entity.User;
import com.gitweb.shop.utli.MybatisMapperUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 */
@WebServlet(name="queryUser",urlPatterns = "/queryUser")
public class QueryUserServlet extends HttpServlet {
    IUserDao userDao= MybatisMapperUtil.getMapper(IUserDao.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //查询数据库数据，将数据存入request
        List<User> users = userDao.selectAllUser();
        req.setAttribute("users",users);
        HttpSession session = req.getSession();
        session.setAttribute("servletName","queryUser");
        //传递请求
        req.getRequestDispatcher("/content.jsp").forward(req,resp);
    }
}
