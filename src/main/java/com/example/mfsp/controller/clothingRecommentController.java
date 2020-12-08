package com.example.mfsp.controller;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Clothingrecomment;
import com.example.mfsp.entity.clothingclass;
import com.example.mfsp.service.clothingRecommentService;
import com.example.mfsp.service.clothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class clothingRecommentController {


    @Autowired
    private clothingRecommentService clothingrecommentservice;

    @Autowired
    private clothingService clothingservice;


    @RequestMapping(value = "/recomment" ,method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> recomment(@RequestParam("userid") Integer userid){
        Map<String, Object> result = new HashMap<String, Object>();
        List<Clothing> clothings=new ArrayList<>();

        Clothingrecomment clothingrecomment=clothingrecommentservice. highestweight(userid);
        clothingclass clothingclass=new clothingclass();
        /////
        System.out.println(clothingrecomment.getClothingclassid());
        /*clothingclass.setClassid(clothingrecomment.getClothingclassid());*/

        clothingclass clothingclass1=clothingservice.findclass(clothingrecomment.getClothingclassid());
        String firstkind=clothingclass1.getFirstKind();
        String secondkind=clothingclass1.getSecondKind();
        String thirdlykind=clothingclass1.getThirdlyKind();

        Clothing clothing=new Clothing();
        clothing.setFirstKind(firstkind);
        clothing.setSecondKind(secondkind);
        clothing.setThirdlyKind(thirdlykind);

        clothings=clothingservice.selectAll(clothing);

        result.put("code", 0);
        result.put("msg", "");
        result.put("count",clothings.size());
        result.put("data", clothings);

        return result;
    }
}
