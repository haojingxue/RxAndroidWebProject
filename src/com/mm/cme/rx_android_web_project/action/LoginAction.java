package com.mm.cme.rx_android_web_project.action;

import com.mm.cme.rx_android_web_project.bean.StateBean;
import com.mm.cme.rx_android_web_project.bean.UserInfoBean;
import com.mm.cme.rx_android_web_project.constants.StateE;
import net.sf.json.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Descriptions：登陆
 * <p>
 * Author：ChenME
 * Date：10/24/2016
 * Email：ibelieve1210@163.com
 */
public class LoginAction extends HttpServlet {

    public LoginAction() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理客户的post请求
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter writer = response.getWriter();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        System.out.println("--username->>" + userName);
        System.out.println("--password->>" + password);

        UserInfoBean userInfo = new UserInfoBean();
        StateBean state = new StateBean();
        HashMap<String, Object> map = new HashMap<>();
        if ("admin".equals(userName) && "12345".equals(password)) {

            state.setStateCode(StateE.SUCCESS);
            state.setStateMessage("登陆成功");

            userInfo.setUserName("admin");
            userInfo.setPassword("12345");
            map.put("userInfo", userInfo);
        } else {
            state.setStateCode(StateE.ERROR);
            state.setStateMessage("用户名或密码错误!");
        }
        map.put("state", state);
        String json_value = JSONSerializer.toJSON(map).toString();
        writer.print(json_value);
        writer.flush();
        writer.close();
    }
}