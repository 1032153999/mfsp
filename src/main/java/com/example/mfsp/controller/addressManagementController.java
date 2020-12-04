package com.example.mfsp.controller;



import com.example.mfsp.entity.Address;
import com.example.mfsp.entity.Clothing;
import com.example.mfsp.service.addressManagementService;
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
public class addressManagementController {

    @Autowired
    private addressManagementService addressmanagementservice;


    @RequestMapping(value = "/queryAdress",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> queryAddress (Address address){
        Map<String,Object> result=new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
//        Address address=new Address();
//        address.setUserid(userid);
        System.out.println(address.toString());
        List<Address> addresses=new ArrayList<>();
        if(address.getUserid()==null){
            System.out.println("userid is null");
        }else{
            addresses=addressmanagementservice.selectAll(address);
        }
        result.put("count",addresses.size());
        result.put("data", addresses);
        return result;
    }

    @RequestMapping(value = "updateAddress",method = RequestMethod.GET)
    @ResponseBody
    public String updateAddress(Address address){
        try{
            addressmanagementservice.updateByPrimaryKeySelective(address);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "defeated";
        }
    }

    @RequestMapping(value = "/deleteAddress" ,method = RequestMethod.GET)
    @ResponseBody
    public String deleteAddress(Address address){
        if(address.getId()==null){
            System.out.println("Id of address is null");
            return "defeated";
        }else {
            addressmanagementservice.delete(address);
            return "success";
        }
    }

    @RequestMapping(value="/addAddress",method = RequestMethod.GET)
    @ResponseBody
    public String addAddress (Address address){
        try{
            addressmanagementservice.insert(address);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "defeated";
        }
    }
}
