package com.gitweb.shop.dao;


import com.gitweb.shop.entity.User;

/**
 * user表相关数据库操作
 */
public interface IUserDao {
    //保存用户信息
    void saveUser(User user);
}
