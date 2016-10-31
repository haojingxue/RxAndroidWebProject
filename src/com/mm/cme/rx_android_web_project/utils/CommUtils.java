package com.mm.cme.rx_android_web_project.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Descriptions：通用工具
 * <p>
 * Author：ChenME
 * Date：10/29/2016
 * Email：ibelieve1210@163.com
 */
public class CommUtils {

    /**
     * 打印信息
     *
     * @param msg message
     */
    public static void p(String msg) {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        System.out.println(sdf.format(new Date()) + " ~~~ " + msg);
    }
}
