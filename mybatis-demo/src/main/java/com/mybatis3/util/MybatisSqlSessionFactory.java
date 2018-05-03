package com.mybatis3.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisSqlSessionFactory {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory == null){
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"development");
            }catch (Exception e){
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSession(){
        return getSqlSessionFactory().openSession();
    }
}
