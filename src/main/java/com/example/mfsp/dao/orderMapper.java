package com.example.mfsp.dao;


import com.example.mfsp.entity.Orderform;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface orderMapper extends Mapper<Orderform> {


}
