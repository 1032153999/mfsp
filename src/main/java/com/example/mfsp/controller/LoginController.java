package com.example.mfsp.controller;

import com.example.mfsp.entity.User;
import com.example.mfsp.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private userService userService;


//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Integer userid, String userpassword, HttpSession session, Model model) {
//
//        //findByUserPassword通过传递过来的用户名和密码，在数据库进行查询，当查询不到用户的时候，返回一个空的User对象，对空的User对象进行逻辑判断，继续下一步业务
//       User userList = userService.findByUserPassword(userid, userpassword);
//        System.out.println(userList);
//        //List<User> userList = userService.findByName(username);
//        if (userList==null) {
//            //返回登录页面
//            model.addAttribute("msg", "输入账号或密码有误，请重新输入！");
//            return "/login";
//        } else {
//            //把user信息保存到session
//
//
//
//            session.setAttribute("USER_SESSION", userid);
//            model.addAttribute("msg", "success");
//            return "/index.html";
//        }
//    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
      public String login(@RequestParam("userid") Integer id , @RequestParam("userpassword") String userpassword , HttpSession session ){
        String msg = "";
        User user = new User();
        user.setUserid(id);
        user.setUserpassword(userpassword);
        List<User> users = userService.selectAll(user);
        System.out.println(users.get(0).getUserrole());
        if(users.get(0) == null){
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
}
