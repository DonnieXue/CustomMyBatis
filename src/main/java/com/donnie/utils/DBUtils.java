package com.donnie.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by BRL on 2018/6/1.
 * jdbc工具类
 */
public class DBUtils {
    private static Logger logger;

    private static final String USER_NAME;//用户名

    private static final String PASSWORD;//密码

    private static final String URL;//数据库连接地址

    private static final String DRIVER;//连接驱动包路径

    private static Connection connection; //数据库连接管理

    static {
        logger = LoggerFactory.getLogger(DBUtils.class);
        USER_NAME = PropertiesUtils.getJdbcValue("username");
        PASSWORD = PropertiesUtils.getJdbcValue("password");
        URL = PropertiesUtils.getJdbcValue("url");
        DRIVER = PropertiesUtils.getJdbcValue("driverClass");
    }


    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
