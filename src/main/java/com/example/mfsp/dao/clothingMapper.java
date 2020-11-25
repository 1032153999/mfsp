package com.example.mfsp.dao;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface clothingMapper  extends Mapper<Clothing> {

    List<Clothing> FuzzySearchClothing(String clothingname);
}
