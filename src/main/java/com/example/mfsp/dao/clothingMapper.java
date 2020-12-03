package com.example.mfsp.dao;


import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.User;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Component
public interface clothingMapper  extends Mapper<Clothing> {

    List<Clothing> FuzzySearchClothing(String clothingname);


    List<String> findProvince();

    List<String> findCity(String province);

    List<String> findDistrict(String province, String city);
}
