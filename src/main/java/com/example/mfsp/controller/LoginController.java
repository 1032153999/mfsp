package com.example.mfsp.controller;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.User;
import com.example.mfsp.service.userService;
import com.example.mfsp.utility.InterceptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private userService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
      public String login(@RequestParam("userid") Integer id , @RequestParam("userpassword") String userpassword , HttpSession session ){
        String msg = "";
        User user = new User();
        user.setUserid(id);
        user.setUserpassword(userpassword);
        List<User> users = userService.selectAll(user);
        if(users.size() == 0 ){
            msg = "用户名或密码错误" ;
            return msg ;
        }else if (users.get(0).getUserrole() == 0 ){
            msg = "admin" ;
            return msg ;
        }else if(users.get(0).getUserrole() ==  1){
            session.setAttribute("USER_SESSION", id);
            msg = "user" ;
            return msg ;
        }else {
            return  "不存在";
        }
    }
//退出登录
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    @ResponseBody
    public String gotologin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        InterceptUtil interceptUtil = new InterceptUtil();
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("USER_SESSION");
        session.removeAttribute("USER_SESSION");
        interceptUtil.openurl(httpServletRequest,httpServletResponse,"/admin.html");
        return "";
    }

}
