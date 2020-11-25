package com.example.mfsp.controller;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Orderform;
import com.example.mfsp.service.clothingService;
import com.example.mfsp.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: UpdateClothingController
 * @Description:
 * @Author
 * @Date 2020/11/24
 * @Version 1.0
 */


@Controller
public class UpdateClothingController {

    @Autowired
    private com.example.mfsp.service.clothingService clothingService;
    @RequestMapping(value="/UpdateClothing",method= RequestMethod.GET)
    @ResponseBody
    public String updateClothing(Clothing clothing){

        //首先给clothing 赋值（） 从前端获取数据赋予clothing值

        clothingService.updateByPrimaryKeySelective(clothing);

        return "success";
    }

}
