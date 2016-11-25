package com.gitweb.shop.utli;

import com.gitweb.shop.dao.ITestDao;
import com.gitweb.shop.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis 接口对象获取工具类
 */
public class MybatisMapperUtil {
    //单例模式
    private static final SqlSessionFactory factory = getFactory();
    //得到xml解析对象
    private static SqlSessionFactory getFactory() {
        //1.得到SqlSessionFactory对象  解析xml文件
        try {
            //指定相对路径，它是以项目中resources为参照的相对路径
            //指定的是mybatis configuration类型xml的地址
            String resource = "mybatis.xml";
            //将该文件转成流形式
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //SqlSessionFactoryBuilder对象的build方法创建SqlSessionFactory的对象。
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            return factory;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("得到SqlSessionFactory对象，异常");
        }
        return null;
    }
    //得到mapper对象
    /**
     *
     * @param tClass  接口映射对象
     * @param <T>     接口类型
     * @return  返回该接口的对象
     */
    public static <T> T getMapper(Class<T> tClass) {
        //创建session，创建jdbc连接
        SqlSession session = factory.openSession();
        //关闭事务
        session.commit(false);
        //得到接口对象    包装statement以及实现接口细节
        // 原理：使用了ava高级特性映射  Class  Method Field
        T t = session.getMapper(tClass);
        return t;
    }
/*    //测试
    public static void main(String[] args) {
        //1.得到SqlSessionFactory对象  解析xml文件
        try {
            //指定相对路径，它是以项目中resources为参照的相对路径
            //指定的是mybatis configuration类型xml的地址
            String resource = "mybatis.xml";
            //将该文件转成流形式
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //SqlSessionFactoryBuilder对象的build方法创建SqlSessionFactory的对象。
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.得到mybatis mappers类型xml中指定接口的对象  相对于得到UserDao的对象
            //隐藏了接口的实现类 的实现细节  原理：使用了ava高级特性映射  Class  Method Field
            //创建session对象   创建connection
            SqlSession session = factory.openSession();
            try {
                //得到接口对象    包装statement以及实现接口细节
                // 原理：使用了ava高级特性映射  Class  Method Field
                ITestDao mapper = session.getMapper(ITestDao.class);
                //调用接口方法，得到sql执行结果
                List<User> users = mapper.selectAllUser();
                for (User user : users) {
                    System.out.println(user.getId());
                }
            } finally {
                session.close();//释放资源
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}
