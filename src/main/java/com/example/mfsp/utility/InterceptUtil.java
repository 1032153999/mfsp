package com.example.mfsp.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InterceptUtil {


    public String openurl(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,String desurl) throws IOException {
        HttpSession session = httpServletRequest.getSession();
//        User user = (User) session.getAttribute("USER_SESSION")
        Integer user_id = (Integer) session.getAttribute("USER_SESSION");
        String homeUrl = httpServletRequest.getContextPath();
        if (user_id == null) {
            System.out.println("获取到项目名，以便下面进行重定向");
            // 获取到项目名，以便下面进行重定向
            // 如果是 ajax 请求，则设置 session 状态 、CONTEXTPATH 的路径值
            // 如果是ajax请求响应头会有，x-requested-with
            if (httpServletRequest.getHeader("x-requested-with") != null && httpServletRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                httpServletResponse.setHeader("SESSIONSTATUS", "TIMEOUT");
                httpServletResponse.setHeader("CONTEXTPATH", homeUrl + "/login.html");
                System.out.println("FORBIDDEN，forbidden。也就是禁止、403");
                // FORBIDDEN，forbidden。也就是禁止、403
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            } else {
                // 如果不是 ajax 请求，则直接跳转即可
                System.out.println("如果不是 ajax 请求，则直接跳转即可");
                httpServletResponse.sendRedirect(homeUrl + "/login.html");
            }
//            return false;
        }else {
            httpServletResponse.setHeader("CONTEXTPATH", homeUrl + desurl);
        }
        return "";
    }
}
