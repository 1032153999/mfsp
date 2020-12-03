package com.example.mfsp.controller;


import com.example.mfsp.entity.Shoppingcart;
import com.example.mfsp.entity.User;
import com.example.mfsp.service.shoppingcartService;
import com.example.mfsp.service.userService;
import com.example.mfsp.utility.InterceptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JumpController {

    @Autowired
    private shoppingcartService shoppingcartService;


    @Autowired
    private com.example.mfsp.service.userService userService;

    @GetMapping(value = "GotoClient")
    @ResponseBody
    public String gotoClient(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        InterceptUtil interceptUtil = new InterceptUtil();
        interceptUtil.openurl(httpServletRequest,httpServletResponse,"/client.html");
        return "";
    }

    @GetMapping(value = "GotoShoppingcart")
    @ResponseBody
    public String gotoShoppingcart(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        InterceptUtil interceptUtil = new InterceptUtil();
        interceptUtil.openurl(httpServletRequest,httpServletResponse,"/placeOrderPage.html");
        return "";
    }

}
