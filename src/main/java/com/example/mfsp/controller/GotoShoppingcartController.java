package com.example.mfsp.controller;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Shoppingcart;
import com.example.mfsp.entity.User;
import com.example.mfsp.service.shoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.mfsp.controller.LoginController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GotoShoppingcartController {

    @Autowired
    private shoppingcartService shoppingcartService;





    @RequestMapping(value = "GotoShoppingcart")
    public ModelAndView up(MultipartFile uploadFile, RedirectAttributes redirectAttributes, HttpSession session) throws IOException {
        Object xinxi = session.getAttribute("USER_SESSION");
        Integer userid =new Integer(xinxi.toString());
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.setUserid(userid);
        List<Shoppingcart> shoppingcarts = new ArrayList<>();
        shoppingcarts = shoppingcartService.selectAll(shoppingcart);
        result.put("count",shoppingcarts.size());
        result.put("data", shoppingcarts);
        System.out.println(shoppingcarts);
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("file", result.toString());
        modelAndView.setViewName("placeOrderPage.html");
        System.out.println(userid);
        return modelAndView;
    }


    @RequestMapping(value = "demo111")
    public boolean  dadasdadas(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        if (user == null) {
            // 获取到项目名，以便下面进行重定向
            String homeUrl = httpServletRequest.getContextPath();
            // 如果是 ajax 请求，则设置 session 状态 、CONTEXTPATH 的路径值
            // 如果是ajax请求响应头会有，x-requested-with
            if (httpServletRequest.getHeader("x-requested-with") != null && httpServletRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                httpServletResponse.setHeader("SESSIONSTATUS", "TIMEOUT");
                httpServletResponse.setHeader("CONTEXTPATH", homeUrl + "/index.html");
                // FORBIDDEN，forbidden。也就是禁止、403
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            } else {
                // 如果不是 ajax 请求，则直接跳转即可
                httpServletResponse.sendRedirect(homeUrl + "/placeOrderPage.html");
            }
            return false;
        }
    }

//    @RequestMapping(value = "/ceshidemo" )
//    public ModelAndView index(@ModelAttribute("file") String  file) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("file", file);
//        // 封装返回结果到Model中
//        // 设置返回的视图名称
//        modelAndView.setViewName("placeOrderPage.html");
//        System.out.println(file);
//        return modelAndView;
//
//    }
//}
