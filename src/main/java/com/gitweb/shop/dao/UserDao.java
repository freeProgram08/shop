package com.gitweb.shop.dao;

import com.gitweb.shop.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * IUserDao实现类
 * 继承跟实现，必须先继承后实现
 */
public class UserDao extends BaseDao implements IUserDao  {
    public  UserDao(){
        //得到数据库连接相关配置
        init();
    }

    @Override
    public void saveUser(User user) {
        //user表数据存储jdbc
        System.out.println("开始保存user");
        String sql="INSERT  INTO " +
                "user(user_name,gender,age,password,hobbies)" +
                "VALUES (?,?,?,?,?);";
        List list=new ArrayList();
        //值顺序很重要，顺序错了，值就错了 根据？顺序加值
        list.add(user.getUserName());
        list.add(user.getGender());
        list.add(user.getAge());
        list.add(user.getPassword());
        list.add(Arrays.toString(user.getHobbies()));
        setSql(sql,list);//调用赋值
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("执行user保存语句失败");
        }
    }

}
