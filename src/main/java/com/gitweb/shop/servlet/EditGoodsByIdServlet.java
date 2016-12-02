package com.gitweb.shop.servlet;

import com.gitweb.shop.dao.IGoodsDao;
import com.gitweb.shop.entity.Goods;
import com.gitweb.shop.utli.MybatisMapperUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/2.
 */
@WebServlet(urlPatterns = "/editGoodsById")
public class EditGoodsByIdServlet extends HttpServlet {
    MybatisMapperUtil util= new MybatisMapperUtil();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");

        IGoodsDao dao=util.getMapper(IGoodsDao.class);
        Integer idValue=Integer.parseInt(id);
        //根据id查询完整商品信息
        Goods goods=dao.selectGoodsById(idValue);
        //保存商品信息
        req.setAttribute("goods",goods);
        //跳转到修改界面
        req.getRequestDispatcher("/content.jsp").forward(req,resp);
    }
}
