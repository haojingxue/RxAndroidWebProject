package com.mm.cme.rx_android_web_project.db;

/**
 * Descriptions：配置文件
 * <p>
 * Author：ChenME
 * Date：10/27/2016
 * Email：ibelieve1210@163.com
 */
public class Config {

//    private static final String ENVIRONMENT = "TEST_ENVIRONMENT";//测试环境
//    private static final String ENVIRONMENT = "PRODUCTION_ENVIRONMENT";//生产环境

    //数据库连接
    public static String DB_DRIVER = null;
    public static String DB_URI = null;
    public static String DB_USER = null;
    public static String DB_PASS = null;

    static {
        //数据库连接
        DB_DRIVER = "com.mysql.jdbc.Driver";
        DB_URI = "jdbc:mysql://localhost:3306/MyCompany?characterEncoding=utf8";
        DB_USER = "root";
        DB_PASS = "123456";


        //home MySql
//        DB_DRIVER = "com.mysql.jdbc.Driver";
//        DB_URI = "jdbc:mysql://localhost:3306/MyCompany?characterEncoding=utf8";
//        DB_USER = "root";
//        DB_PASS = "root";
    }
}
