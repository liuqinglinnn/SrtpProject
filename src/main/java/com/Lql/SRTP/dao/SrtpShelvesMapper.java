package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.SrtpShelves;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SrtpShelvesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SrtpShelves record);

    int insertSelective(SrtpShelves record);

    SrtpShelves selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SrtpShelves record);

    int updateByPrimaryKey(SrtpShelves record);
}