package com.gitweb.shop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 过滤登录
 */
@WebFilter(urlPatterns = "/*")
public class FilterLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      /*  ServletRequest是 HttpServletRequest的父类
                在该业务里，使用的对象就是HttpServletRequest的对象*/
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String servletPath = req.getServletPath();
        if(servletPath.contains("/login")||
                servletPath.contains("/register")||
                servletPath.endsWith(".jpg")
                ||servletPath.endsWith(".png")
                ||servletPath.endsWith(".js")
                ||servletPath.endsWith(".css")
                ){//先放行不过滤页面
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
            return;//结束业务
        }
        //得到会话对象
        HttpSession session = req.getSession();
        //取出登录成功时，存储的user
        Object user = session.getAttribute("user");
        if(user==null){//验证登录不成功
            resp.sendRedirect("/login.jsp");
            return;
        }
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
