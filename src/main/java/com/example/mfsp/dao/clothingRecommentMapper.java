package com.example.mfsp.dao;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Clothingrecomment;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface clothingRecommentMapper extends Mapper<Clothingrecomment> {
    String updateweight(Integer clothingrecommentid);

    String updateweight1(Integer clothingrecommentid);

    String updateweight2(Integer clothingrecommentid);

    Clothingrecomment highestweight(Integer userid);
}
