package com.mm.cme.rx_android_web_project.dao;

import com.mm.cme.rx_android_web_project.bean.StateBean;
import com.mm.cme.rx_android_web_project.bean.UserInfoBean;
import com.mm.cme.rx_android_web_project.constants.StateE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Descriptions：登陆
 * <p>
 * Author：ChenME
 * Date：10/29/2016
 * Email：ibelieve1210@163.com
 */
public class LoginDao {

    public HashMap<String, Object> checkInDao(Connection conn, String userName, String password) {

        //定义变量
        HashMap<String, Object> map = new HashMap<>();
        UserInfoBean userInfo = new UserInfoBean();
        StateBean state = new StateBean();

        String sql = "SELECT * FROM Employees WHERE userName = ?";
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1, userName);
            ResultSet rs = stat.executeQuery();

            if (rs.next()) {
                rs.previous();
                boolean isHasThisUser = false;
                while (rs.next()) {
                    String passwordFromDB = rs.getString("password");
                    if (password.equals(passwordFromDB)) {
                        userInfo.setUserName(userName);
                        userInfo.setPassword(passwordFromDB);
                        map.put("userInfo", userInfo);
                        state.setStateCode(StateE.SUCCESS);
                        state.setStateMessage("登陆成功！");
                        isHasThisUser = true;
                        break;
                    }
                }
                if (!isHasThisUser) {
                    state.setStateCode(StateE.ERROR);
                    state.setStateMessage("密码错误!");
                }
            } else {
                state.setStateCode(StateE.ERROR);
                state.setStateMessage("抱歉！您还尚未注册！");
            }
            rs.close();
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
            state.setStateCode(StateE.ERROR);
            state.setStateMessage("用户名或密码错误!");
        }

        map.put("state", state);
        return map;
    }
}