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
import java.util.List;

/**
 *
 */
@WebServlet(urlPatterns = "/queryGoods")
public class QueryGoodsServlet extends HttpServlet {
    //数据库的核心工具类
    MybatisMapperUtil util= new MybatisMapperUtil();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //查询数据库，将数据存入请求
        IGoodsDao goodsDao=util.getMapper(IGoodsDao.class);
        List<Goods> allGoods = goodsDao.getAllGoods();
        req.setAttribute("allGoods",allGoods);
        //获取session
        HttpSession session = req.getSession();
        session.setAttribute("servletName","queryGoods");
        //重定向 不能保留请求数据，传递请求可以
        req.getRequestDispatcher("/content.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String goodsName = req.getParameter("goodsName");
        String type = req.getParameter("type");
        String price = req.getParameter("price");
        Integer typeValue=null;//用null做假设  代表没有
        /*isEmpty  字符串 空 true 不空 false*/
        if(type!=null&&!type.isEmpty()){//不空 开始赋值
            typeValue=Integer.parseInt(type);
        }
        Double priceValue=null;
        if(price!=null&&!price.isEmpty()){
            priceValue=Double.parseDouble(price);
        }
        Goods goods = new Goods();
        goods.setPrice(priceValue);
        goods.setType(typeValue);
        if(goodsName!=null&&!goodsName.isEmpty()){//不空才赋值
            goods.setGoodsName(goodsName);
        }
        //查询数据库
        IGoodsDao goodsDao=util.getMapper(IGoodsDao.class);
        List<Goods>allGoods=goodsDao.selectByGoods(goods);

        req.setAttribute("allGoods",allGoods);
        //获取session
        HttpSession session = req.getSession();
        session.setAttribute("servletName","queryGoods");
        //重定向 不能保留请求数据，传递请求可以
        req.getRequestDispatcher("/content.jsp").forward(req,resp);
    }
}
