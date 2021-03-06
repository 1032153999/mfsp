package com.example.mfsp.controller;

import com.example.mfsp.entity.Favourites;
import com.example.mfsp.service.favouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.soap.Addressing;

@Controller
public class DeleteFavouritesController {


    @Autowired
    private com.example.mfsp.service.favouritesService favouritesService;


    @RequestMapping(value = "deletefavourites", method = RequestMethod.GET)
    @ResponseBody
    public  String deletefavourites(@RequestParam("favouritesid") int favouriteid){
        Favourites favourites = new Favourites();
        favourites.setFavouritesid(favouriteid);
         favouritesService.delete(favourites);
         return "";
        }
}
