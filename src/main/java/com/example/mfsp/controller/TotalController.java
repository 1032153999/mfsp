package com.example.mfsp.controller;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Orderform;
import com.example.mfsp.entity.User;
import com.example.mfsp.service.clothingService;
import com.example.mfsp.service.orderService;
import com.example.mfsp.service.userService;

import org.omg.CORBA.WStringSeqHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TotalController {

    @Autowired
    private clothingService clothingService;

    @Autowired
    private orderService orderService;

    @Autowired
    private userService userService;

    //统计租量控制类 前端注意返回的是一个数组！！！！！分别为 租量总量跟最高租量！
    @RequestMapping(value = "zuliang")
    @ResponseBody
    public int[] totalrent(){
        List<Clothing> clothings;
        clothings = clothingService.selectAll();
        int sum= clothings.stream().mapToInt(Clothing::getClothingmonrentalamount).sum();
        List<Integer> rent = clothings.stream().map(Clothing::getClothingmonrentalamount).collect(Collectors.toList());
        int mostrent = Collections.max(rent);
        int [] msg ={sum,mostrent};
        return msg;
    }


    //查询总销量及最高销量控制类， 前端注意接收到的数组类型！！！
    @RequestMapping(value = "xiaoliang")
    @ResponseBody
    public int[] totalsales(){
        List<Clothing> clothings;
        clothings = clothingService.selectAll();
        int sum= clothings.stream().mapToInt(Clothing::getClothingmonthlysales).sum();
        List<Integer> sales = clothings.stream().map(Clothing::getClothingmonthlysales).collect(Collectors.toList());
        int mostsales = Collections.max(sales);
        int[] msg = {sum,mostsales};
        System.out.println(msg);
        return msg;
    }

    // 统计订单金额 总量及最高订单金额  前端注意 传过去的是一个数组！！！！！！
    @RequestMapping(value = "ordertotal")
    @ResponseBody
    public int[] totalorders(){
        List<Orderform> orderforms;
        Orderform orderform = new Orderform();
        orderform.setOrderstatus("已处理");
        orderforms = orderService.selectAll(orderform);
        List<String> total = orderforms.stream().map(Orderform::getTotalprice).collect(Collectors.toList());
        System.out.println(total);
        List<Integer> numtotal =new ArrayList<>();
        for (int i = 0; i<total.size(); i++){
            int zhongzhuan = Integer.parseInt(total.get(i));
            System.out.println(zhongzhuan);
            numtotal.add(i,zhongzhuan);
            System.out.println(numtotal);
        }
        int mostprice = Collections.max(numtotal);
        int sum = numtotal.stream().reduce(Integer::sum).orElse(0);
        int [] msg ={sum,mostprice};
        return  msg;
    }


    //通知用户控制类  ，前端注意此处返回的是一个数组
    @RequestMapping(value = "usertotal")
    @ResponseBody
    public int[] usertotal(){
        User user = new User();
        user.setUserrole(0);
        List<User> users;
        List<User> usersrole;
        users = userService.selectAll();
        usersrole = userService.selectAll(user);
        int [] usertotal = {users.size(),usersrole.size()};
        System.out.println(usertotal);
        return usertotal;
    }



    //查询订单数量控制类！ 前端注意传到的是一个数组！！！！！！！！！顺序分别为 订单数，订单未处理数，订单正在处理数，订单已处理数
    @RequestMapping(value = "queryordernumber")
    @ResponseBody
    private int[] ordernum(){
        Orderform orderform = new Orderform();
        int ordernumber = orderService.selectAll().size();
        orderform.setOrderstatus("未处理");
        int ordernumber2 = orderService.selectAll(orderform).size();
        orderform.setOrderstatus(("处理中"));
        int ordernumber3 = orderService.selectAll(orderform).size();
        orderform.setOrderstatus("已处理");
        int ordernumber4 = orderService.selectAll(orderform).size();
        int [] msg = {ordernumber,ordernumber2,ordernumber3,ordernumber4};
        return  msg;
    }

    //查询商品数的控制类， 注意！！！！传来的是一个数组 值依次为商品数量，库存过低数量，无库存，库存充足 库存过低指的是库存小于100件的
    @RequestMapping(value = "queryallclothingsnumber")
    @ResponseBody
    public int[] queryclothingnumber(){
        int numberis0 = 0;
        int numberlittle = 0;
        int numberenough = 0;
        List<Clothing> clothings = clothingService.selectAll();
        int sum= clothings.stream().mapToInt(Clothing::getClothingnum).sum();
        List<Integer> clothingnum = clothings.stream().map(Clothing::getClothingnum).collect(Collectors.toList());
        for (int i = 0; i<clothingnum.size(); i++){
            if (clothingnum.get(i) == 0){
                numberis0++;
            }else if (clothingnum.get(i) < 100){
                numberlittle++;
            }else {
                numberenough++;
            }
        }
        int [] msg = {sum,numberlittle,numberis0,numberenough};
        return  msg;
    }


    //查询最火商品控制类 注意传来的是一个数组！ 值依次为 商品名称，库存，销售量，租赁量
    //
    @RequestMapping(value = "queryhostclothing")
    @ResponseBody
    public  String[] queryhostclothing(){
        Clothing clothing = new Clothing();
        List<Clothing> clothings = clothingService.selectAll();
        List<Integer> clothingnum1 = clothings.stream().map(Clothing::getClothingmonthlysales).collect(Collectors.toList());
        List<Integer> clothingnum2 = clothings.stream().map(Clothing::getClothingmonrentalamount).collect(Collectors.toList());
        List<Integer> clothingtotal = new ArrayList<>();
        System.out.println(clothingnum1.get(0));
        for (int i =0; i <clothingnum1.size(); i++){
            clothingtotal.add(i,clothingnum1.get(i)+clothingnum2.get(i));
        }
        int max =Collections.max(clothingtotal);
        int maxindex = clothingtotal.indexOf(max);
        String name = clothings.get(maxindex).getClothingname();
        int number = clothings.get(maxindex).getClothingnum();
        int sales = clothings.get(maxindex).getClothingmonthlysales();
        int rent = clothings.get(maxindex).getClothingmonrentalamount();
        String[] msg = {name, String.valueOf(number), String.valueOf(sales), String.valueOf(rent)};
        return msg;

    }

    //查询最活跃用户  返回数组。值依次为用户ID  订单数， 成交金额，电话号码


}
