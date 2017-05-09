package com.mm.cme.rx_android_web_project.utils;

import com.mm.cme.rx_android_web_project.utils.base64.AESUtils;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;

/**
 * Descriptions：字符串工具类
 * <p>
 * Author：ChenME
 * Date：10/29/2016
 * Email：ibelieve1210@163.com
 */
public class StringUtils {

    private static final String PARAMETER_KEY = "info";

    /**
     * 将HttpRequest解密为JSONObject
     *
     * @param request HttpRequest
     * @return JSONObject
     */
    public static JSONObject decodeHttpRequest2JSONObject(HttpServletRequest request) {
        String jsonStr = null;

        jsonStr = request.getParameter(PARAMETER_KEY);
        if (jsonStr == null) {
            jsonStr = (String) request.getAttribute(PARAMETER_KEY);
        }
//        CommUtils.p("StringUtil工具json(未解码)~~"+jsonStr);
//        AESUtils en = new AESUtils();
//        try {
//            jsonStr = en.Decrypt(jsonStr);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        CommUtils.p("StringUtil工具json(已解密)~~"+jsonStr);
        JSONObject obj = JSONObject.fromObject(jsonStr);
        return obj;
    }
}
