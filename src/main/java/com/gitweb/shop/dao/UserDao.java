package com.gitweb.shop.dao;

import com.gitweb.shop.entity.User;

/**
 * IUserDao实现类
 */
public class UserDao implements IUserDao {
    @Override
    public void saveUser(User user) {
        //user表数据存储jdbc
        System.out.println("开始保存user");
    }
}
