package com.gitweb.shop.servlet;

import com.gitweb.shop.dao.IUserDao;
import com.gitweb.shop.entity.User;
import com.gitweb.shop.utli.MybatisMapperUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 用户注册
 */
@WebServlet(name="register",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    //一般关于业务相关的对象，我们会抽成属性
    //方便方法共享
    MybatisMapperUtil util= new MybatisMapperUtil();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         /*为了支持中文，指定字符编码*/
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        //getParameterValues用于多选框，用于同一个name有多个值的情况
        String[] hobbies = req.getParameterValues("hobby");
        //完成了接受请求参数
        //不允许用户名重复
        IUserDao userDao = util.getMapper(IUserDao.class);
        User oldUser = userDao.verifyUserName(userName);
        if(oldUser!=null){//如果不为空，说明数据库已存在一个该用户
            //存储错误信息
            req.setAttribute("error","用户名已存在");
            //请求转发
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            return;//结束注册业务
        }
        //user对象的作用，数据库跟java之间的桥梁
        User user = new User();
        user.setGender(Boolean.parseBoolean(gender));
        user.setAge(Integer.parseInt(age));
        user.setHobbies(Arrays.toString(hobbies));
        user.setPassword(password);
        user.setUserName(userName);
        userDao.saveUser(user);
        //1.传递请求  req  可以传输数据
        //2.重定向   resp   不可以传数据
        resp.sendRedirect("/registerSuccess.html");
    }
}
