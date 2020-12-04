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
    private String addaddress(@RequestParam("useraddress") String useraddress, @RequestParam("userid") int userid){
        Address address = new Address();
        address.setUseraddress(useraddress);
        address.setUserid(userid);
        addressManagementService.insert(address);
        return "添加成功";
    }

    //
}



