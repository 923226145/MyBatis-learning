package com.example.mybatis;

import com.example.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用原生接口
 */
public class App1 {
    public static void main( String[] args ) {
        // 加载 MyBatis 配置文件
        InputStream is = App1.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 调用 MyBatis 原生接口执行 SQL
        // statement 为 UserMapper.xml 的 namespace 值+"."+select 标签的 id 值
        String statement = "com.example.mybatis.mapper.UserMapper.getUserByUserName";
        User user = sqlSession.selectOne(statement , "lizhencheng");
        // SqlSession的selectOne(String var1, Object var2)方法
        // 可以发现第二个参数是Object类型的,
        // 例子中我们只传递了一个参数, 如果想传入多个参数的话, 可以传递一个Map或者是一个实体类对象
        System.out.println(user);
    }
}
