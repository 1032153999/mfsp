package com.example.mfsp.service;

import com.example.mfsp.entity.Clothing;

import java.util.List;

public interface clothingService extends baseService<Clothing> {

    List<Clothing>FuzzySearchClothing(String clothingname);
}
