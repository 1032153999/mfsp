package com.example.mfsp.controller;



import com.example.mfsp.entity.pcd;
import com.example.mfsp.service.clothingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class testController {


    @Autowired
    private clothingService clothingservice;

    /**
     * 下拉框动态获取省
     * @return
     */
    @RequestMapping(value = "queryProvince")
    @ResponseBody
    public String findProvince(){

        System.out.println(clothingservice.findProvince());

        List<String> list=new ArrayList<String>();
        list=clothingservice.findProvince();
        String result=  String.join(",",list);
        System.out.println(result);

        return result;
    }



    /*获取市*/


    @RequestMapping(value = "queryCity")
    @ResponseBody
    public String findCity(String province){
        List<String> list=new ArrayList<String>();
        list=clothingservice.findCity(province);
        String result=  String.join(",",list);
        System.out.println(result);
       return result;

    }



    @RequestMapping(value="queryDistrict")
    @ResponseBody
    public String findDistrict(String province,String city){
        List<String> list=new ArrayList<String>();
        list=clothingservice.findDistrict(province,city);
        String result=  String.join(",",list);
        System.out.println(result);
        return result;
    }

}
