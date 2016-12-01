package com.gitweb.shop.servlet;

import com.gitweb.shop.dao.IGoodsDao;
import com.gitweb.shop.utli.MybatisMapperUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/destroyGoodsById")
public class DestroyGoodsById extends HttpServlet {
    MybatisMapperUtil util= new MybatisMapperUtil();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
       /* 超链接传值，通过key取值
       * 如id=2，那么key就是id  值是2*/
        String id = req.getParameter("id");
        //获取IGoodsDao 对象
        IGoodsDao goodsDao = util.getMapper(IGoodsDao.class);
        /*执行删除*/
        goodsDao.destroyGoodsById(Integer.parseInt(id));
        //要不要传值  哪个服务可以帮忙再查一次数据库
        //不需要传值  重定向  已有的查所有服务是/queryGoods
        resp.sendRedirect("/queryGoods");
    }
}
