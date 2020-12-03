package com.example.mfsp.controller;



import com.example.mfsp.entity.Address;
import com.example.mfsp.service.addressManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class addressManagementController {

    @Autowired
    private addressManagementService addressmanagementservice;


    @RequestMapping(value = "/queryAdress",method = RequestMethod.GET)
    @ResponseBody
    public List<Address>  queryAddress (Integer userid){
        Address address=new Address();
        address.setUserid(userid);
        return addressmanagementservice.selectAll(address);
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
