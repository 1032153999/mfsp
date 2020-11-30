package com.example.mfsp.controller;

import com.example.mfsp.entity.User;
import com.example.mfsp.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private userService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String username, String userpassword, HttpSession session, Model model) {
        //获取用户信息
       List<User> userList = userService.findByName(username, userpassword);
        //List<User> userList = userService.findByName(username);
        if (CollectionUtils.isEmpty(userList)) {
            //返回登录页面
            model.addAttribute("msg", "输入账号或密码有误，请重新输入！");
            return "/login";
        } else {
            //把user信息保存到session
            User stored = new User();
            stored.setUsername(username);
            stored.setUserpassword(userpassword);
            session.setAttribute("USER_SESSION", stored);
            model.addAttribute("msg", "success");
            return "/index";
        }
    }
}
