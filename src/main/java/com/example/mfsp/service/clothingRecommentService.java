package com.example.mfsp.service;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Clothingrecomment;

public interface clothingRecommentService extends baseService<Clothingrecomment> {
    String updateweight(Integer clothingrecommentid);

    String updateweight1(Integer clothingrecommentid);

    String updateweight2(Integer clothingrecommentid);

    Clothingrecomment highestweight(Integer userid);
}
