package com.gitweb.shop.dao;


import com.gitweb.shop.entity.User;

import java.util.List;

/**
 * user表相关数据库操作
 */
public interface IUserDao {
    //保存用户信息
    void saveUser(User user);
     //通过用户名查询用户
    User  verifyUserName(String userName);
    //返回数据库user表所有的数据
    List<User>  selectAllUser();
}
