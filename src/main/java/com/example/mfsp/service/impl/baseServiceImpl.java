package com.example.mfsp.service.impl;

import com.example.mfsp.service.baseService;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName: baseServiceImpl
 * @Description: for test tkmybatis
 * @Author
 * @Date 2020/11/20
 * @Version 1.0
 */

@SuppressWarnings("all")
public abstract class baseServiceImpl<T> implements baseService<T> {
    @Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }




    @Override
    public List<T> selectAll(T record) {
        return mapper.select(record);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public String updateByExample(T record, T obj){
        mapper.updateByExample(record,obj);

        return "success";
    }


    @Override
    public String updateByExampleSelective(T record, T obj){
        mapper.updateByExampleSelective(record,obj);

        return "success";
    }


    @Override
    public String updateByPrimaryKeySelective(T record){
        mapper.updateByPrimaryKeySelective(record);

        return "success";
    }


    @Override
    public String insert(T record){
        mapper.insert(record);
        return "success";
    }

    public String delete(T record){
        mapper.delete(record);
        return "success";
    }



}
