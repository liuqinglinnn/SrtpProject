package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.SrtpShelvesDis;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SrtpShelvesDisMapper {
    int insert(SrtpShelvesDis record);

    int insertSelective(SrtpShelvesDis record);
}