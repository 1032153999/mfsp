package com.example.mfsp.controller;


import com.example.mfsp.entity.Orderform;
import com.example.mfsp.service.orderService;
import com.example.mfsp.utility.TimeTackleUtil;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class AddOrderController {

    @Autowired
    private orderService orderService;

    private TimeTackleUtil timeTackleUtil;


    @GetMapping("AddOrder")
    @ResponseBody
    public String addOrder(Orderform orderform, HttpSession httpSession, @RequestParam("month") Integer month,@RequestParam("days") Integer days){
        System.out.println("AddOrder");
        System.out.println("AddOrder"+ orderform.toString()+"month"+month+"days"+days);
        timeTackleUtil=new TimeTackleUtil();
        Date current = new Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "MMddHHmmss");
        String time = sdf.format(current);
        int time2 =Integer.parseInt(time);
        System.out.println(time2);
        System.out.println(time);
        orderform.setOrderformid(time2);
        httpSession.setAttribute("orderid",time2);


        if(month==null&&days==null){
            /*
                购买
             */
            System.out.println("AddOrderBuy"+ orderform.toString());
            orderService.insert(orderform);

        }else {
             /*
                租赁
             */

            if(month==null){
                  /*
                30日内租赁
             */

                timeTackleUtil.currentPlusDay(days);
                orderform.setPreconcertedreturntime(timeTackleUtil.currentPlusDay(days));
                System.out.println("AddOrderByDays"+ orderform.toString()+"days"+days);
////                timeTackleUtil.plusDay2(days);
//
//                System.out.println("timeTackleUtil.currentPlusDay(days)========="+timeTackleUtil.currentPlusDay(days));
                orderService.insert(orderform);

            }else if(days==null) {
                   /*
               按月租赁
             */

                orderform.setPreconcertedreturntime(timeTackleUtil.currentPlusDay(month*30));


                System.out.println("AddOrderBYMonth"+ orderform.toString()+"month"+month);


//
                      orderService.insert(orderform);
            }

        }






        return "success";
    }


}
