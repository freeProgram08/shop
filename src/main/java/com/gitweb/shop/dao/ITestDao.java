package com.gitweb.shop.dao;

import com.gitweb.shop.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */
public interface ITestDao {
    List<User>  selectAllUser();
}
