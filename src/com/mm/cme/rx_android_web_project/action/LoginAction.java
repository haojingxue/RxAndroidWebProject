package com.mm.cme.rx_android_web_project.action;

import com.mm.cme.rx_android_web_project.bean.StateBean;
import com.mm.cme.rx_android_web_project.bean.UserInfoBean;
import com.mm.cme.rx_android_web_project.constants.StateE;
import com.mm.cme.rx_android_web_project.server.LoginServer;
import com.mm.cme.rx_android_web_project.utils.StringUtils;
import net.sf.json.JSONObject;
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
        //字符集设置
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //解析
        JSONObject jsonObj = StringUtils.decodeHttpRequest2JSONObject(request);
//        String userName = jsonObj.getString("userName");
//        String password = jsonObj.getString("password");

        String userName =  request.getParameter("userName");
        String password = request.getParameter("password");

        //创建变量
        HashMap<String, Object> map = new LoginServer().checkUserValidity(userName, password);

        String json_value = JSONSerializer.toJSON(map).toString();

        PrintWriter writer = response.getWriter();
        writer.print(json_value);
        writer.flush();
        writer.close();
    }
}