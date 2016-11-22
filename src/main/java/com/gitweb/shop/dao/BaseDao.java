package com.gitweb.shop.dao;

import java.sql.*;
import java.util.List;

/**
 * BaseDao 不具有可使用性
 * 处理一些通用操作
 */
public  abstract class BaseDao {
    //定义通用属性
    protected Connection con;//连接对象
    protected Statement statement;//数据库操作对象
    protected PreparedStatement preparedStatement;//高级数据库操作对象
    //初始化con，statement对象
    //连接本地的shop子库，赋值con，statement
    protected void init(){
        String user="root";
        String  password="12345";
        String url="jdbc:mysql://localhost:3306/shop";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("web容器加载mysql驱动失败");
        }
        try {
            //赋值连接属性
            con= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            System.out.println("得到连接失败");
            e.printStackTrace();
        }
        try {
            //赋值数据库操作属性
            statement=con.createStatement();
        } catch (SQLException e) {
            System.out.println("得到数据库操作对象失败");
            e.printStackTrace();
        }
    }

    /**
     * 给有问号的sql 赋值
     * @param sql 待赋值sql
     * @param list  有顺序的参数列表
     */
    protected void setSql(String sql,List list){
        try {
            preparedStatement=con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("用户save语句不可解析");
        }
        //第一个？尝试赋值成String，值为user.getBrowserName()
        try {
            for(int i=0;i<list.size();i++){//循环赋值？
                preparedStatement.setObject(i+1,list.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("setSql异常");
        }
    }
}
