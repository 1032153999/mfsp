package com.example.mfsp.dao;

import com.example.mfsp.entity.Address;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface addressManagementMapper extends Mapper<Address> {

}
