package com.example.mfsp.dao;

import com.example.mfsp.entity.Favourites;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;


@Component
public interface favouritesMapper  extends Mapper<Favourites> {
}
