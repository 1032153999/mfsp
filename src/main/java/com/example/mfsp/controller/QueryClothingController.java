package com.example.mfsp.controller;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Orderform;
import com.example.mfsp.service.clothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QueryClothingController {

    @Autowired
    private clothingService clothingService;


//    @RequestMapping(value = "/QueryClothing" , method = RequestMethod.GET)
//    @ResponseBody
//    public Map<String, Object> QueryClothing() {
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("code", 0);
//        result.put("msg", "");
//
//        List<Clothing> clothings=new ArrayList<>();
//        clothings=clothingService.selectAll();
//        result.put("count",clothings.size());
//        result.put("data", clothings);
//        System.out.println("endddd");
//        return result;
//    }

// //通过ID查询单个服装数据
//    @RequestMapping(value="/QueryClothingById",method= RequestMethod.GET)
//    @ResponseBody
//    public Map<String, Object> QueryClothingById(@RequestParam("id")  Integer id) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("code", 0);
//        result.put("msg", "");
//        Clothing clothing=new Clothing();
//        clothing.setClothingid(id);
//        List<Clothing> clothings=new ArrayList<>();
//        clothings=clothingService.selectAll(clothing);
//        result.put("count",clothings.size());
//        result.put("data", clothings);
//        System.out.println("endddd");
//        return result;
//    }

    //通过衣服种类查询单一种类衣服查询。
    @RequestMapping(value="/QueryClothingByType",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> QueryClothingByType(@RequestParam("type")  String type) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        Clothing clothing=new Clothing();
        clothing.setClothingtype(type);
        clothing.setClothingstatus("库存");
        List<Clothing> clothings=new ArrayList<>();
        clothings=clothingService.selectAll(clothing);
//        result.put("count",clothings.size());
//        result.put("data", clothings);
        System.out.println("endddd");

        System.out.println(type);
        if (clothings.size() == 0  ){
            result.put("data","搜索不到相关服装");
        }else{
            result.put("count",clothings.size());
            result.put("data", clothings);
        }
        return result;
    }


    //通过对象查询单个服装数据
    @RequestMapping(value="/QueryClothingByObj",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> QueryClothingByObj(@RequestBody(required = true)  Clothing clothing) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        List<Clothing> clothings=new ArrayList<>();
        if(clothing.getClothingid()==null){
            System.out.println("clothing.getClothingid()==null");
            clothings =clothingService.selectAll();
        }else {
            clothings =clothingService.selectAll(clothing);

        }


        result.put("count",clothings.size());
        result.put("data", clothings);

        return result;
    }

 //通过ID查询单个服装数据
    @RequestMapping(value="/QueryClothingById0",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> QueryClothingById(@RequestParam("clothingid")  Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        Clothing clothing=new Clothing();
        List<Clothing> clothings=new ArrayList<>();
        if(id==0){
            clothings=clothingService.selectAll();
        }else {
            clothing.setClothingid(id);
            clothings=clothingService.selectAll(clothing);
        }
        System.out.println(clothings);

        result.put("count",clothings.size());
        result.put("data", clothings);
        System.out.println("endddd");
        return result;
    }


    @RequestMapping(value = "QueryClothingByIdee", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView toParticulars(@RequestParam("clothingid")  Integer id){//参数传入对象
        Clothing clothing = new Clothing();
        clothing.setClothingid(id);
        Object yifu = clothingService.selectAll(clothing).get(0);
        ModelAndView mav = new ModelAndView();
        //要跳转的页面
        mav.setViewName("admin.html");
        //传入对象
        mav.addObject("yifu",yifu);
        System.out.println(mav.getViewName());


        return mav;
    }







//跳转服装详细页面方法
    @RequestMapping(value = "ceshi", method= RequestMethod.GET)
    @ResponseBody
     public ModelAndView toParticulars(List<Clothing> clothings,@RequestParam("clothingid")  Integer id){

        Clothing clothing = new Clothing();
        clothing.setClothingid(id);
        clothings=clothingService.selectAll(clothing);
        ModelAndView mav =new ModelAndView();
        mav.setViewName("demo2.html");
        mav.addObject("clothings",clothings);
        return  mav;
     }

     /*根据服装租赁价格排序----降序*/
     @RequestMapping(value="/sortedbyrentalprice",method = RequestMethod.GET)
     @ResponseBody
     public List<Clothing> sortedbyrentalprice (){

        List<Clothing> clothings= new ArrayList<>();
        clothings=clothingService.sortedbyrentalprice();
        return clothings;
     }
     /*根据服装租赁价格排序----升序*/
     @RequestMapping(value="/sortedbyrentalprice1",method=RequestMethod.GET)
     @ResponseBody
     public List<Clothing> sortedbyrenttalprice1 (){
        return clothingService.sortedbyrentalprice1();
     }

     /*根据服装价格排序----升序*/
    @RequestMapping(value="/sortedbyprice",method=RequestMethod.GET)
    @ResponseBody
    public List<Clothing> sortedbyprice (){
        return clothingService.sortedbyprice();
    }

    /*根据服装价格排序----降序*/
    @RequestMapping(value="/sortedbyprice1",method=RequestMethod.GET)
    @ResponseBody
    public List<Clothing> sortedbyprice1 (){
        return clothingService.sortedbyprice1();
    }

}

