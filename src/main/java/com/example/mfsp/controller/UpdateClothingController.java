package com.example.mfsp.controller;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Orderform;
import com.example.mfsp.service.clothingService;
import com.example.mfsp.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDate;
import java.util.List;

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

//    @RequestMapping(value="/123",method= RequestMethod.GET)
//    @ResponseBody
//    public String updateClothing(Clothing clothing, RedirectAttributes redirectAttributes){
//
//        //首先给clothing 赋值（） 从前端获取数据赋予clothing值
//        clothing.setClothingid(1);
//        clothing.setClothingnum(10);
//        clothingService.updateByPrimaryKeySelective(clothing);
//
//
//        return "success";
//    }




    //点击购物车结算按键，相应用户选择购物车商品并结算，后台重定向给订单生成controller类以及传输总价跟
    @RequestMapping(value="/UpdateClothing",method= RequestMethod.GET)
    public String updateClothing(Clothing clothing, RedirectAttributes redirectAttributes, @RequestParam("userid")  Integer userid){
        //首先给clothing 赋值（） 从前端获取数据赋予clothing值

//        clothingService.updateByPrimaryKeySelective(clothinglines.get(0));   MultipartFile uploadFile,
        clothing.getClothingprice();
        redirectAttributes.addAttribute("buypirce",clothing.getClothingprice());
        redirectAttributes.addAttribute("userid",userid);
        redirectAttributes.addAttribute("file", LocalDate.now().toString()  );

        return "redirect:index";
    }

    @RequestMapping("/index")
    public ModelAndView index(@ModelAttribute("name") String name, @ModelAttribute("file") String file){
        ModelAndView modelAndView = new ModelAndView();
        if(name != null){
            modelAndView.addObject("name", name);
            modelAndView.addObject("file", file);
        }
//        Orderform orderform=new
        System.out.println("1356151651");
        // 封装返回结果到Model中
        // 设置返回的视图名称
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

//接受前端发来的衣服对象， 提取出其中衣服的num从而改变库存数量
    @GetMapping("/reduceclothingnum")
    @ResponseBody
    public String updateclothingNum(Clothing clothing){
        System.out.println("clothing.toString()"+clothing.toString());
        Integer id =clothing.getClothingid();
        Integer num = clothing.getClothingnum();
        Clothing queryclothing = new Clothing();
        queryclothing.setClothingid(id);
        Integer num2 = clothingService.selectAll(queryclothing).get(0).getClothingnum();
        clothing.setClothingnum(num2-num);
        clothingService.updateByPrimaryKeySelective(clothing);
        return "suceess";
    }

}
