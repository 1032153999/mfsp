package com.example.mfsp.controller;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Clothinginorder;
import com.example.mfsp.entity.Clothingrecomment;
import com.example.mfsp.entity.clothingclass;
import com.example.mfsp.service.clothingRecommentService;
import com.example.mfsp.service.clothingService;
import com.example.mfsp.service.clothinginorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@Controller
public class AddclothinginorderController {

    @Autowired
    private clothinginorderService clothinginorderService;

    @Autowired
    private clothingService clothingservice;

    @Autowired
    private clothingRecommentService clothingrecommentservice;




    /*@GetMapping(value = "/clothinginorder")
    @ResponseBody
    private  String  inoder(Clothing clothing, HttpSession httpSession){
        Object zhongzhuan = httpSession.getAttribute("orderid");
        int id =Integer.parseInt(zhongzhuan.toString());
        Clothinginorder clothinginorder = new Clothinginorder();

        clothinginorder.setOrderformid(id);
        clothinginorder.setClothingid(clothing.getClothingid());
        clothinginorder.setClothingprice(clothing.getClothingprice());
        clothinginorder.setClothingname(clothing.getClothingname());
        clothinginorder.setClothingdescr(clothing.getClothingdescr());
        clothinginorder.setCionum(clothing.getClothingnum());
        System.out.println("clothinginorder"+clothinginorder.toString());
        clothinginorderService.insert(clothinginorder);
        return "";




    }*/

    @GetMapping(value = "/clothinginorder")
    @ResponseBody
    private  String  inoder(Clothing clothing, HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException, IOException {
        Object zhongzhuan = httpSession.getAttribute("orderid");
        int id =Integer.parseInt(zhongzhuan.toString());
        Clothinginorder clothinginorder = new Clothinginorder();

        clothinginorder.setOrderformid(id);
        clothinginorder.setClothingid(clothing.getClothingid());
        clothinginorder.setClothingprice(clothing.getClothingprice());
        clothinginorder.setClothingname(clothing.getClothingname());
        clothinginorder.setClothingdescr(clothing.getClothingdescr());
        clothinginorder.setCionum(clothing.getClothingnum());
        System.out.println("clothinginorder"+clothinginorder.toString());
        clothinginorderService.insert(clothinginorder);

        System.out.println("已经进入推荐算法--购买服装");
        HttpSession session = httpServletRequest.getSession();
        Integer user_id = (Integer) session.getAttribute("USER_SESSION");
        System.out.println(user_id);

        String firstkind=clothing.getFirstKind();
        String secondkind=clothing.getSecondKind();
        String thirdlykind=clothing.getThirdlyKind();

        System.out.println(firstkind+secondkind+thirdlykind);
        clothingclass clothingclass=clothingservice.selectclassid(firstkind,secondkind,thirdlykind);

        Clothingrecomment recomment=new Clothingrecomment();
        recomment.setUserid(user_id);
        recomment.setClothingclassid(clothingclass.getClassid());
        List<Clothingrecomment> recomments=clothingrecommentservice.selectAll(recomment);
        if(recomments.size()>0){

            clothingrecommentservice.updateweight(recomments.get(0).getClothingrecommentid());
            System.out.println(recomments.get(0).getClothingrecommentid()+"的推荐值+3");
        }else {
            recomment.setRecommendweight(3);
            clothingrecommentservice.insert(recomment);
            System.out.println("insert clothingweight ");
        }








        return "";




    }



}
