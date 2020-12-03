package com.example.mfsp.dao;

import com.example.mfsp.entity.Clothing;
import com.example.mfsp.entity.Clothingcomment;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface clothingCommentMapper extends Mapper<Clothingcomment> {
}
