package com.gitweb.shop.servlet;

import com.gitweb.shop.dao.IUserDao;
import com.gitweb.shop.dao.UserDao;
import com.gitweb.shop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录服务
 */
@WebServlet(name = "login",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    IUserDao userDao=new UserDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("userName");
        String password = req.getParameter("pass");
        //根据用户名查询user数据
        User user = userDao.verifyUserName(userName);
        //如果user为null ，说明数据库没有数据  该用户名未注册
        if(user==null){
            req.setAttribute("error","用户不存在");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;//业务结束
        }
        //判断密码是否正确
        if(!user.getPassword().equals(password)){
            req.setAttribute("error","密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;//业务结束
        }
        //登录成功  保存用户信息
        //获取会话对象
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        //重定向到登录成功页面
        resp.sendRedirect("/content.jsp");
    }
}
