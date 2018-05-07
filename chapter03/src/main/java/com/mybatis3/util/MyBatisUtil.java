package com.mybatis3.util;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MyBatisUtil {
    private static final String DEFAULT_MYBATIS_CONFIG_FILE="mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory;
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            InputStream is = Resources.getResourceAsStream("db.properties");
            PROPERTIES.load(is);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory == null){
            try {
                InputStream inputStream = Resources.getResourceAsStream(DEFAULT_MYBATIS_CONFIG_FILE);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }catch (Exception e){
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession(){
        return getSqlSessionFactory().openSession();
    }
}
