package com.example.mfsp.controller;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.service.clothingService;
import jdk.nashorn.internal.ir.RuntimeNode;
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
@RequestMapping("/admin")
public class clothingManagementController {

    @Autowired
    private clothingService clothingservice;


    /*根据服装序号查找服装*/
    @RequestMapping(value="/SelectClothingById",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> SelectClothingById(@RequestParam("id")  Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        Clothing clothing=new Clothing();
        clothing.setClothingid(id);
        List<Clothing> clothings=new ArrayList<>();
        clothings=clothingservice.selectAll(clothing);
        result.put("count",clothings.size());
        result.put("data", clothings);
      /*  System.out.println("endddd");
        System.out.println(id);*/
        return result;
    }

    /*查询全部服装*/
    @RequestMapping(value="/SelectAllClothing", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> SelectAllClothing() {
        Map<String, Object> clothingresult = new HashMap<String, Object>();
        clothingresult.put("code", 0);
        clothingresult.put("msg", "");

        List<Clothing> clothings=new ArrayList<>();
        clothings=clothingservice.selectAll();
        clothingresult.put("count",clothings.size());
        clothingresult.put("data", clothings);
        System.out.println("All clothings is selected ");

        System.out.println("orderforms.get(0);"+clothings.get(0).getClothingid()+clothings.get(0).getClothingname());
        return clothingresult;
    }

    /*修改服装信息
    * 返回情况不清楚*/
    @RequestMapping(value="/updateClothing",method= RequestMethod.GET)
    public String updateOrder(Clothing clothing){
        clothingservice.updateByPrimaryKeySelective(clothing);

       /* String T=clothing.toString();
        System.out.println(T);*/
        return "";
    }

    /*添加服装信息
    返回情况不清楚
    */
    @RequestMapping(value = "/addClothing",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addClothing(Clothing clothing){
        Map<String, Object> result = new HashMap<String, Object>();
        List<Clothing> clothings=new ArrayList<>();
        if(clothing.getClothingid()==0){
            clothings=clothingservice.selectAll();
        }else {
            clothingservice.insert(clothing);
            clothings=clothingservice.selectAll();
        }
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",clothings.size());
        result.put("data", clothings);
        String f=clothing.toString();
        System.out.println(f);
        return result;
    }

    /*删除服装信息
    返回情况不清楚
     */

    @RequestMapping(value="/deleteByID",method=RequestMethod.GET)
    @ResponseBody
    public String deleteByID(@RequestParam("id")  Integer id){
        Clothing clothing=new Clothing();
        clothing.setClothingid(id);
        clothingservice.delete(clothing);
        return "success";
    }


    /*测试模块*/
    @RequestMapping(value="/Test",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> test(){
        Clothing clothing01=new Clothing();

       /* clothing01.setClothingname("棉裤");
        clothing01.setClothingcost("12");
        clothing01.setClothingprice("100");
        clothing01.setClothingrentprice("10");
        clothing01.setClothingnum(20);
        clothingservice.insert(clothing01);*/

        clothing01.setClothingid(3);
        clothingservice.delete(clothing01);

        List<Clothing> clothings=new ArrayList<>();
        clothings=clothingservice.selectAll();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",clothings.size());
        result.put("data", clothings);

        String c=clothing01.toString();
        System.out.println("clothing01:"+c);


        return result;
    }

    @RequestMapping(value="/FuzzySearchClothing", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> FuzzySearchClothing(@RequestParam("name")  String clothingname){

        Map<String, Object> result = new HashMap<String, Object>();
        List<Clothing> clothings=new ArrayList<>();
        System.out.println(clothingname);
        clothings=clothingservice.FuzzySearchClothing(clothingname);
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",clothings.size());
        result.put("data", clothings);

        return result;
    }


}
