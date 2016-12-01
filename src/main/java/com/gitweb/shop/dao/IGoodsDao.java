package com.gitweb.shop.dao;

import com.gitweb.shop.entity.Goods;

import java.util.List;

/**
 *定义需实现的方法
 */
public interface IGoodsDao {
    //保存商品
    void  saveGoods(Goods goods);
    //查询所有的商品
    List<Goods> getAllGoods();
    //根据商品查询
    List<Goods> selectByGoodsName(String goodsName);
    //根据商品对象属性值查询商品
    List<Goods> selectByGoods(Goods goods);
    //根据id删除商品
    void destroyGoodsById(Integer id);
}
