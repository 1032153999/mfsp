package com.example.mfsp.service;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.clothingclass;

import java.util.List;

public interface clothingService extends baseService<Clothing> {

    List<Clothing>FuzzySearchClothing(String clothingname);

    List<String> findFirstKind();

    List<String> findSecondKind(String FirstKind);

    List<String> findThirdlyKind(String FirstKind, String SecondKind);

    List<Clothing> sortedbyrentalprice();

    List<Clothing> sortedbyrentalprice1();

    List<Clothing> sortedbyprice();

    List<Clothing> sortedbyprice1();

    clothingclass selectclassid(String FirstKind, String SecondKind,String ThirdlyKind);

    clothingclass findclass(Integer classid);
}
