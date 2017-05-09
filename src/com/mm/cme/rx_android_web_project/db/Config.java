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
        DB_URI = "jdbc:mysql://outwuliupai.mysql.rds.aliyuncs.com:3306/testdb?characterEncoding=utf8";
        DB_USER = "chenmengen";
        DB_PASS = "MyalyDBKey1210";

//        DB_DRIVER = "com.mysql.jdbc.Driver";
//        DB_URI = "jdbc:mysql://localhost:3306/mm_db?characterEncoding=utf8";
//        DB_USER = "root";
//        DB_PASS = "root";


        //home MySql
//        DB_DRIVER = "com.mysql.jdbc.Driver";
//        DB_URI = "jdbc:mysql://localhost:3306/MyCompany?characterEncoding=utf8";
//        DB_USER = "root";
//        DB_PASS = "root";
    }
}
