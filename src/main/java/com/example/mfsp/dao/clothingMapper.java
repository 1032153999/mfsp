package com.example.mfsp.dao;


import com.example.mfsp.entity.Clothing;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface clothingMapper  extends Mapper<Clothing> {

    List<Clothing> FuzzySearchClothing(String clothingname);


    List<String> findFirstKind();

    List<String> findSecondKind(String FirstKind);

    List<String> findThirdlyKind(String FirstKind, String SecondKind);
}
