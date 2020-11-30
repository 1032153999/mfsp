package com.example.mfsp.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.User;
import com.example.mfsp.service.userService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class userManagementController {

    @Autowired
    private userService userservice;


    /*根据服装序号查找服装*/
    @RequestMapping(value="/SelectUserById",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> SelectClothingById(@RequestParam("userid")  Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        User user=new User();
        user.setUserid(id);
        List<User> users=new ArrayList<>();
        if(user.getUserid()==0){
            users=userservice.selectAll();
        }else{
            users=userservice.selectAll(user);
        }
        result.put("count",users.size());
        result.put("data", users);
      /*  System.out.println("endddd");
        System.out.println(id);*/
        return result;
    }

    @RequestMapping(value="/SelectAllUser", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> SelectAllUser() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");

        List<User> users=new ArrayList<>();
        users=userservice.selectAll();
        result.put("count",users.size());
        result.put("data", users);
        System.out.println("All users is selected ");

        System.out.println("users.get(0);"+users.get(0).getUserid()+users.get(0).getUsername());
        return result;
    }

    @GetMapping("/deleteUserByID")
    @ResponseBody
    public String deleteByID(User user) {


        userservice.delete(user);
        return "success";
    }

    /*根据用户姓名  模糊查询*/
    @RequestMapping(value="/FuzzySearchUser", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> FuzzySearchUser(@RequestParam("name")  String username){

        Map<String, Object> result = new HashMap<String, Object>();
        List<User> users=new ArrayList<>();
        System.out.println(username);
        users=userservice.FuzzySearchUser(username);
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",users.size());
        result.put("data", users);

        return result;
    }


    /*上传用户图片调用 clothingManagementController 的 “ /upload " */

}
