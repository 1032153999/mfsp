package com.example.mfsp.service.impl;

import com.example.mfsp.dao.clothingMapper;
import com.example.mfsp.entity.Clothing;
import com.example.mfsp.service.clothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class clothingServiceImpl extends baseServiceImpl<Clothing> implements clothingService {

    @Autowired
    private clothingMapper clothingmapper;


    @Override
    public List<Clothing> FuzzySearchClothing(String clothingname) {

        System.out.println(clothingname);
        return clothingmapper.FuzzySearchClothing(clothingname);
    }

    @Override
    public  List<String> findFirstKind(){
        return clothingmapper.findFirstKind();
    }
    @Override
    public List<String> findSecondKind(String FirstKind){
        return clothingmapper.findSecondKind(FirstKind);
    }
    @Override
    public List<String> findThirdlyKind(String FirstKind, String SecondKind){

        return clothingmapper.findThirdlyKind(FirstKind,SecondKind);
    }
    @Override
    public List<Clothing> sortedbyrentalprice (){
        return clothingmapper.sortedbyrentalprice();
    }

    @Override
    public List<Clothing> sortedbyrentalprice1 (){
        return clothingmapper.sortedbyrentalprice1();
    }

    @Override
    public List<Clothing> sortedbyprice(){
        return clothingmapper.sortedbyprice();
    }
    @Override
    public List<Clothing> sortedbyprice1(){
        return clothingmapper.sortedbyprice1();
    }

}
