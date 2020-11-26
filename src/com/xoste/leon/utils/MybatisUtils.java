package com.xoste.leon.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    private  static SqlSessionFactory factory = null;
    private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 连接SqlSession
    * */
    public static SqlSession getSqlSession() {
        SqlSession session = tl.get();
        if (session == null) {
            tl.set(factory.openSession());
        }
        return tl.get();
    }

    /*
    * 关闭SqlSession
    * */
    public static void closeSqlSession() {
        SqlSession session =  tl.get();
        if (session != null) {
            session.close();
        }
        tl.set(null);
    }
}
