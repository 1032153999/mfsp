package com.example.mfsp.controller;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Clothingcomment;
import com.example.mfsp.service.clothingCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class clothinggCommentController {


    @Autowired
    private clothingCommentService clothingCommentservice;

    /*
    * 添加评论
    * */
    @RequestMapping(value="/addcomment",method = RequestMethod.GET)
    @ResponseBody
    public String addcomment(Clothingcomment clothingcomment){

//        System.out.println("userid and clothingid is :"+userid+clothingid);
//        System.out.println("comment:"+comment);

//        Clothingcomment clothingcomment=new Clothingcomment();
        System.out.println(clothingcomment.toString());
        clothingCommentservice.insert(clothingcomment);
        return "ok";

    }

    /*
    * 查询评论
    * 根据服装ID
    * */

    @RequestMapping(value="/selectCommentByclothingid",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectCommentByclothingid(Clothingcomment clothingcomment){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
//        Clothingcomment clothingcomment=new Clothingcomment();
//        clothingcomment.setClothingid(clothingid);

        List<Clothingcomment> clothingcomments=new ArrayList<>();
        clothingcomments=clothingCommentservice.selectAll(clothingcomment);

        result.put("count",clothingcomments.size());
        result.put("data", clothingcomments);
        return result;
    }

    /*
    * 查询评论
    * 根据用户ID
    * */
    @RequestMapping(value="/selectCommentByUserid",method = RequestMethod.GET)
    public Map<String,Object> selectCommentByUserid(Integer userid){
        Map<String, Object> result = new HashMap<String, Object>();
        Clothingcomment clothingcomment=new Clothingcomment();
        clothingcomment.setUserid(userid);
        List<Clothingcomment> clothingcomments=new ArrayList<>();
        clothingcomments=clothingCommentservice.selectAll(clothingcomment);
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",clothingcomments.size());
        result.put("data", clothingcomments);
        return result;
    }



}
