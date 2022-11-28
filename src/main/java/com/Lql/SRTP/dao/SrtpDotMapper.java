package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.SrtpDot;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SrtpDotMapper {
    int insert(SrtpDot record);

    int insertSelective(SrtpDot record);
}