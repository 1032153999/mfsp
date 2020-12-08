package com.example.mfsp.dao;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.clothingclass;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface clothingMapper  extends Mapper<Clothing> {

    List<Clothing> FuzzySearchClothing(String clothingname);


    List<String> findFirstKind();

    List<String> findSecondKind(String FirstKind);

    List<String> findThirdlyKind(String FirstKind, String SecondKind);

    List<Clothing> sortedbyrentalprice();

    List<Clothing> sortedbyrentalprice1();

    List<Clothing> sortedbyprice();

    List<Clothing> sortedbyprice1();

    clothingclass selectclassid(String FirstKind, String SecondKind, String ThirdlyKind);

    clothingclass findclass(Integer classid);
}
