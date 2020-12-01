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
import java.util.List;

@Controller
public class GotoShoppingcartController {

    @Autowired
    private shoppingcartService shoppingcartService;


    @RequestMapping(value = "shoppingcart", method = RequestMethod.POST)
    public String up(MultipartFile uploadFile, RedirectAttributes redirectAttributes) throws IOException {
        Integer id = 1 ;
        Shoppingcart shoppingcart = new Shoppingcart();
        shoppingcart.setUserid(id);
        List<Shoppingcart> shoppingcarts = new ArrayList<>();
        shoppingcarts = shoppingcartService.selectAll(shoppingcart);
        redirectAttributes.addAttribute("file", shoppingcarts);
        return "redirect:ceshidemo";
    }

    @RequestMapping("/ceshidemo")
    public ModelAndView index(@ModelAttribute("file") Object file) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("file", file);
        // 封装返回结果到Model中
        // 设置返回的视图名称
        modelAndView.setViewName("demo2.html");
        System.out.println(file);
        return modelAndView;

    }
}
