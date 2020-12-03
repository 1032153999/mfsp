package com.example.mfsp.controller;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Clothingcomment;
import com.example.mfsp.service.clothingCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public void addcomment(Integer userid,Integer clothingid,String comment){
        System.out.println("userid and clothingid is :"+userid+clothingid);
        System.out.println("comment:"+comment);
        Clothingcomment clothingcomment=new Clothingcomment();
        clothingcomment.setClothingid(clothingid);
        clothingcomment.setUserid(userid);
        clothingcomment.setComment(comment);
        clothingCommentservice.insert(clothingcomment);
    }

    /*
    * 查询评论
    * 根据服装ID
    * */

    @RequestMapping(value="/selectCommentByclothingid",method = RequestMethod.GET)
    public Map<String,Object> selectCommentByclothingid(Integer clothingid){
        Map<String, Object> result = new HashMap<String, Object>();
        Clothingcomment clothingcomment=new Clothingcomment();
        clothingcomment.setClothingid(clothingid);
        List<Clothingcomment> clothingcomments=new ArrayList<>();
        clothingcomments=clothingCommentservice.selectAll(clothingcomment);
        result.put("code", 0);
        result.put("msg", "");
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
