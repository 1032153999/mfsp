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
}
