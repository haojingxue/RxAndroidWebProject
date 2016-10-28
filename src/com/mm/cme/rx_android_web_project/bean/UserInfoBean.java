package com.mm.cme.rx_android_web_project.bean;

/**
 * Descriptions：用户信息
 * <p>
 * Author：ChenME
 * Date：10/24/2016
 * Email：ibelieve1210@163.com
 */
public class UserInfoBean {
    private String userName;
    private String password;

    public UserInfoBean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}