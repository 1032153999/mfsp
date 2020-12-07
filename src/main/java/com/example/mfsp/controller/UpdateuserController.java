package com.example.mfsp.controller;



import com.example.mfsp.entity.Address;
import com.example.mfsp.entity.Orderform;
import com.example.mfsp.entity.User;
import com.example.mfsp.service.addressManagementService;
import com.example.mfsp.service.orderService;
import com.example.mfsp.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//用户在个人中心修改信息controller类
@Controller
public class UpdateuserController {


    @Autowired
    private userService userService;

    @Autowired
    private addressManagementService addressManagementService;

    @Autowired
    private orderService orderService;



    //修改个人信息Controller类
    @RequestMapping(value = "updatemyuser")
    @ResponseBody
    private String updateuser(HttpServletRequest httpServletRequest, @RequestParam("username") String username, @RequestParam("phone") long phone, @RequestParam("userpic")String userpic){
        User user = new User();
        HttpSession session = httpServletRequest.getSession();
        Integer userid = (Integer) session.getAttribute("USER_SESSION");
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
    private String addaddress(HttpServletRequest httpServletRequest, @RequestParam("useraddress") String useraddress){

        Address address = new Address();
        HttpSession session = httpServletRequest.getSession();
        Integer userid = (Integer) session.getAttribute("USER_SESSION");
        User user = new User();
        user.setUserid(userid);
        address.setUsername(userService.selectAll(user).get(0).getUsername());
        address.setUserphone(userService.selectAll(user).get(0).getPhone());

        address.setUseraddress(useraddress);
        address.setUserid(userid);
        addressManagementService.insert(address);
        return "添加成功";
    }


    //查询个人地址
    @RequestMapping(value = "getaddress")
    @ResponseBody
    private Map<String, Object> getaddress(HttpServletRequest httpServletRequest){
        System.out.println("进入");
        Address address = new Address();
        HttpSession session = httpServletRequest.getSession();
        Integer userid = (Integer) session.getAttribute("USER_SESSION");
        address.setUserid(userid);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        List<Address> address1=new ArrayList<>();
        address1 = addressManagementService.selectAll(address);
        result.put("count",address1.size());
        result.put("data", address1);
        return result;


    }


    //验证密码是否符合原密码 以便进行后续密码修改
    @RequestMapping(value = "checkuserpassword")
    @ResponseBody
    private String checkuserpassword(HttpServletRequest httpServletRequest,@RequestParam("userpassword") String userpassword){
        User user = new User();
        HttpSession session = httpServletRequest.getSession();
        Integer userid = (Integer) session.getAttribute("USER_SESSION");
        user.setUserid(userid);
        if(userService.selectAll(user).get(0).getUserpassword()!= userpassword ){
            return "密码不符合";
        }else {
            return "success";
        }
    }

    //修改密码 controller类
    @RequestMapping(value = "updatepassword")
    @ResponseBody
    private  String updateuserpassword(HttpServletRequest httpServletRequest, @RequestParam("userpassword") String userpassword){
        User user = new User();
        HttpSession session = httpServletRequest.getSession();
        Integer userid = (Integer) session.getAttribute("USER_SESSION");
        user.setUserid(userid);
        user.setUserpassword(userpassword);
        userService.updateByPrimaryKeySelective(user);
        return  "修改成功";
    }



    //个人中心处查看订单所调用的方法
    @RequestMapping(value="/Queryuserorder",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryOrderByUid(HttpServletRequest httpServletRequest) {
        System.out.println("123");
        HttpSession session = httpServletRequest.getSession();
        Integer userid = (Integer) session.getAttribute("USER_SESSION");
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");

        List<Orderform> orderforms=new ArrayList<>();
        if(userid==0){
            orderforms=orderService.selectAll();
        }else {
            Orderform orderform=new Orderform();
            orderform.setOrderformid(userid);
            orderforms=orderService.selectAll(orderform);
        }

        result.put("count",orderforms.size());
        result.put("data", orderforms);

        return result;
    }

    //个人中心查看个人信息方法
    @RequestMapping(value="/Queryuser",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryUserByUid(HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession();
        Integer userid = (Integer) session.getAttribute("USER_SESSION");

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");

        List<User> users=new ArrayList<>();
        User user = new User();
        user.setUserid(userid);
        users = userService.selectAll(user);

        result.put("count",users.size());
        result.put("data", users.get(0));

        return result;
    }







}




