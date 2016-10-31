package com.mm.cme.rx_android_web_project.server;

import com.mm.cme.rx_android_web_project.dao.LoginDao;
import com.mm.cme.rx_android_web_project.db.DBUtils;

import java.sql.Connection;
import java.util.HashMap;

/**
 * Descriptions：登陆
 * <p>
 * Author：ChenME
 * Date：10/29/2016
 * Email：ibelieve1210@163.com
 */
public class LoginServer {

    /**
     * 检查用户的合法性
     *
     * @return
     */
    public HashMap<String, Object> checkUserValidity(String userName, String password) {


        //连接数据库
        DBUtils dbUtils = new DBUtils();
        Connection conn = dbUtils.getConnection();

        LoginDao loginDao = new LoginDao();

        return loginDao.checkInDao(conn, userName, password);
    }
}
