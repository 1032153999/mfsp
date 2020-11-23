package com.example.mfsp.dao;

import com.example.mfsp.entity.Clothing;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface clothingManagementMappeer extends Mapper<Clothing> {
}
