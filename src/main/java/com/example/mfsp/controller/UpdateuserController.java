package com.example.mfsp.controller;
//用户在个人中心修改信息controller类


import com.example.mfsp.entity.Address;
import com.example.mfsp.entity.User;
import com.example.mfsp.service.addressManagementService;
import com.example.mfsp.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UpdateuserController {


    @Autowired
    private userService userService;

    @Autowired
    private addressManagementService addressManagementService;



    //修改个人信息Controller类
    @RequestMapping(value = "updatemyuser")
    @ResponseBody
    private String updateuser(@RequestParam("userid") int userid, @RequestParam("username") String username, @RequestParam("phone") long phone,@RequestParam("userpic")String userpic){
        User user = new User();
        user.setUserid(userid);
        user.setUsername(username);
        user.setPhone(phone);
        user.setUserpic(userpic);
        userService.updateByPrimaryKeySelective(user);
        return "修改成功";
    }


    //添加个人地址controller类
    @RequestMapping(value = "insertaddress")
    @ResponseBody
    private String addaddress(@RequestParam("useraddress") String useraddress, @RequestParam("userid") int userid){
        Address address = new Address();
        address.setUseraddress(useraddress);
        address.setUserid(userid);
        addressManagementService.insert(address);
        return "添加成功";
    }


    //验证密码是否符合原密码 以便进行后续密码修改
    @RequestMapping(value = "checkuserpassword")
    @ResponseBody
    private String checkuserpassword(@RequestParam("userid") int userid,@RequestParam("userpassword") String userpassword){
        User user = new User();
        user.setUserid(userid);
        if(userService.selectAll(user).get(0).getUserpassword()!= userpassword ){
            return "密码不符合";
        }else {
            return "密码符合";
        }
    }

    //修改密码 controller类
    @RequestMapping(value = "updatepassword")
    @ResponseBody
    private  String updateuserpassword(@RequestParam("userpassword") String userpassword,@RequestParam("userid") int userid){
        User user = new User();
        user.setUserid(userid);
        user.setUserpassword(userpassword);
        userService.updateByPrimaryKeySelective(user);
        return  "修改成功";
    }









    //
}




