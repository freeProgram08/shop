package com.gitweb.shop.dao;

import com.gitweb.shop.entity.Goods;

/**
 *定义需实现的方法
 */
public interface IGoodsDao {
    void  saveGoods(Goods goods);
}
