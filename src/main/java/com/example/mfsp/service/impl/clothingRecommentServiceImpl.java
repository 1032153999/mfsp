package com.example.mfsp.service.impl;

import com.example.mfsp.dao.clothingRecommentMapper;
import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Clothingrecomment;
import com.example.mfsp.service.clothingRecommentService;
import com.example.mfsp.service.clothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clothingRecommentServiceImpl extends baseServiceImpl<Clothingrecomment> implements clothingRecommentService {
    @Autowired
    clothingRecommentMapper clothingRecommentmapper;

    @Override
    public String updateweight(Integer clothingrecommentid){
        return clothingRecommentmapper.updateweight(clothingrecommentid);
    }

    @Override
    public String updateweight1(Integer clothingrecommentid){
        return clothingRecommentmapper.updateweight1(clothingrecommentid);
    }
    @Override
    public  String updateweight2(Integer clothingrecommentid){
        return clothingRecommentmapper.updateweight2(clothingrecommentid);
    }
    @Override
    public Clothingrecomment highestweight(Integer userid){
        return clothingRecommentmapper.highestweight(userid);
    }
}
