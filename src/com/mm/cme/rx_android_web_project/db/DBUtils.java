package com.mm.cme.rx_android_web_project.db;

import java.sql.*;  // for standard JDBC programs
import java.math.*; // for BigDecimal and BigInteger support

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：10/27/2016
 * Email：ibelieve1210@163.com
 */
public class DBUtils {

    private Connection conn;

    private static String driver;
    private static String uri;
    private static String user;
    private static String pwd;

    static {
        loadDbCfg();
        loadDriver();
    }

    public DBUtils() {
        createConnection();
    }

    /**
     * 加载驱动
     */
    private static void loadDriver() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载数据库的配置项
     */
    private static void loadDbCfg() {
        driver = Config.DB_DRIVER;
        uri = Config.DB_URI;
        user = Config.DB_USER;
        pwd = Config.DB_PASS;
    }

    /**
     * 创建数据库连接
     */
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(uri, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return Connection
     */
    public Connection getConnection() {
        return this.conn;
    }

    /**
     * 关闭数据库连接
     */
    public void closeConn() {
        try {
            if (null != conn && !conn.isClosed()) {
                conn.close();
            }
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}