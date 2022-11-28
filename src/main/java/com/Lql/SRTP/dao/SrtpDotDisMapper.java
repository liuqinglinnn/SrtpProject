package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.SrtpDotDis;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SrtpDotDisMapper {
    int insert(SrtpDotDis record);

    int insertSelective(SrtpDotDis record);
}