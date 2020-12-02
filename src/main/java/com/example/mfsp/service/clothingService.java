package com.example.mfsp.service;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.pcd;

import java.util.List;
import java.util.Map;

public interface clothingService extends baseService<Clothing> {

    List<Clothing>FuzzySearchClothing(String clothingname);

    List<String>findProvince();

    List<String> findCity(String province);

    List<String> findDistrict(String province, String city);
}
