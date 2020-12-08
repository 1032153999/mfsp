package com.example.mfsp.controller;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Favourites;
import com.example.mfsp.entity.Shoppingcart;
import com.example.mfsp.service.clothingService;
import com.example.mfsp.service.favouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QueryFavouritesController {

    @Autowired
    private favouritesService favouritesService;

    @Autowired
    private clothingService clothingService;

    //通过userid查询用户的收藏夹
    @RequestMapping(value="/QueryFavourites",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> QueryFavouritesbyid(HttpServletRequest httpServletRequest) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        HttpSession session = httpServletRequest.getSession();
        Integer userid = (Integer) session.getAttribute("USER_SESSION");
        Favourites favourites =new Favourites();
        favourites.setUserid(userid);
        List<Favourites> favourite=new ArrayList<>();
        favourite = favouritesService.selectAll(favourites);
        result.put("count",favourite.size());
        result.put("data", favourite);
        System.out.println("endddd");
        return result;
    }

    }
