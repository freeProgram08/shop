package com.gitweb.shop.servlet;

import com.gitweb.shop.dao.IGoodsDao;
import com.gitweb.shop.entity.Goods;
import com.gitweb.shop.utli.MybatisMapperUtil;

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
    MybatisMapperUtil util= new MybatisMapperUtil();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //替换servletName值，起到切换页面内容的效果
        session.setAttribute("servletName","addGoods");
        req.getRequestDispatcher("/content.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从请求中取数据
        String goodsName = req.getParameter("goodsName");
        String price = req.getParameter("price");
        String type = req.getParameter("type");
        double priceValue = Double.parseDouble(price);
        int typeValue = Integer.parseInt(type);
        //将数据包装成对象
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goods.setPrice(priceValue);
        goods.setType(typeValue);
        //得到数据库操作对象
        IGoodsDao goodsDao = util.getMapper(IGoodsDao.class);
        //调用方法，执行操作
        goodsDao.saveGoods(goods);
        //不需要传值 用重定向  就是超链接
        resp.sendRedirect("/queryGoods");
    }
}
