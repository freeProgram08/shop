package com.gitweb.shop.dao;

import com.gitweb.shop.entity.User;

import java.sql.ResultSet;
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

    @Override
    public User verifyUserName(String userName) {
        System.out.println("开始通过用户名查询user");
        String sql="SELECT * FROM user where user_name=?";
        List list=new ArrayList();
        //添加参数值
        list.add(userName);
        //配置参数值
        setSql(sql,list);
        List<User> users = getUsers();
        if(users==null){//判断是否查询失败
            return null;//查询失败返回null
        }
        return  users.get(0);//查询到值返回第一个
    }

    //user表集合查询转换
    private List<User> getUsers(){
        //准备接受user对象的集合
        List<User> users=new ArrayList<>();
        try {
            //执行查询，得到查询结果集
            ResultSet result = preparedStatement.executeQuery();
            //将查询结果集转为user对象集合
            while (result.next()){
                User user = new User();
                user.setId(result.getInt("id"));
                user.setUserName(result.getString("user_name"));
                user.setPassword(result.getString("password"));
                user.setGender(result.getBoolean("gender"));
                String hobbiesStr = result.getString("hobbies");
                //消除[]
                String substring = hobbiesStr.substring(1, hobbiesStr.length()-1).trim();
                //分割字符串split 根据字符串分割成字符串数组
                String[] hobbies = substring.split(", ");
                user.setHobbies(hobbies);
                users.add(user);//将user加入集合
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(users.size()==0){//元素为0 没有查询到数据
            return null;//null作为没查询到值
        }
        return  users;//查询到数就返回正常值
    }

    public static void main(String[] args) {
        String [] array={"lookBook","watchVideo","你好"};
        System.out.println(Arrays.toString(array));
        String str = Arrays.toString(array);
        //subString(startIndex,endIndex) 包含startIndex，不包含endIndex
        //trim()消除字符串前后空格
        String substring = str.substring(1, str.length()-1).trim();
        System.out.println(substring);
        String[] split = substring.split(", ");
        System.out.println(Arrays.toString(split));
    }
}
