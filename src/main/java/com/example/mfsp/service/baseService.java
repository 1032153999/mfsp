package com.example.mfsp.service;

import java.util.List;

public interface baseService<T> {
    List<T> selectAll(T record);
    List<T> selectAll();
    String updateByExample(T record,T obj);
    String updateByExampleSelective(T record,T obj);
    String updateByPrimaryKeySelective(T record);

}
