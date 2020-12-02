package com.example.mfsp.controller;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Shoppingcart;
import com.example.mfsp.service.shoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GotoShoppingcartController {

    @Autowired
    private shoppingcartService shoppingcartService;


    @RequestMapping(value = "shoppingcart", method = RequestMethod.GET)
    public String up(MultipartFile uploadFile, RedirectAttributes redirectAttributes) throws IOException {
        Integer id = 4;
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.setUserid(id);
        List<Shoppingcart> shoppingcarts = new ArrayList<>();
        shoppingcarts = shoppingcartService.selectAll(shoppingcart);
        result.put("count",shoppingcarts.size());
        result.put("data", shoppingcarts);
        redirectAttributes.addAttribute("file", result.toString());
        System.out.println(1231561561);
        return "redirect:ceshidemo";
    }

    @RequestMapping(value = "/ceshidemo" , method = RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("file") Object file) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("file", file);
        // 封装返回结果到Model中
        // 设置返回的视图名称
        modelAndView.setViewName("placeOrderPage.html");
        System.out.println(file);
        return modelAndView;

    }
}
