package com.example.mfsp.controller;

import com.example.mfsp.entity.User;
import com.example.mfsp.service.userService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Controller
public class RegisterController {
    //导入UserDao接口
    @Autowired
    private userService userService;

    /**
     * 用户注册
     */
//    @RequestMapping("/register")
//    public ModelAndView register(User user) {
//        ModelAndView mav = new ModelAndView();
//        //判断填写内容是否有空
//        if (user.getUsername().equals("") || user.getUserpassword().equals("")) {
//            mav.addObject("err", "账号和密码不能为空");
//            mav.setViewName("register");
//            return mav;
//        }
//        //判断username是否已存在
//        List<User> userList = userService.findByName(user.getUsername());
//        if (CollectionUtils.isEmpty(userList)) {
//            userService.register(user);
//            //返回主页面
//            mav.setViewName("/register");
//            return mav;
//        }
//        mav.setViewName("/index");
//        return mav;
//    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
      public String register(@RequestParam("userid") Integer id, @RequestParam("userpassword") String userpassword, @RequestParam("phone") String phone){
          String msg = " ";
          System.out.print(phone);
          long numphone = Long.valueOf(phone);
          User user = new User();
          User user2 = new User();
          user.setUserid(id);
          user2.setPhone(numphone);
          List<User> users = userService.selectAll(user);
          List<User> users2 = userService.selectAll(user2);
          if (users.size() == 0&&users2.size()==0 ){
              user.setUserpassword(userpassword);
              user.setPhone(numphone);
              user.setUserrole(1);
              user.setUsername("尊敬的用户");
              userService.insert(user);
              msg = "注册成功";
              return msg;
          }else if (users.size() > 0){
              msg = "userid";
              return msg;
          }else if (users2.size()>0){
              msg = "phone";
              return  msg;
          }else {
              return  msg;
          }








      }

}

