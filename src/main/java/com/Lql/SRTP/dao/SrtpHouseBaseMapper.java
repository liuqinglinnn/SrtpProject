package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.SrtpHouseBase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SrtpHouseBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SrtpHouseBase record);

    int insertSelective(SrtpHouseBase record);

    SrtpHouseBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SrtpHouseBase record);

    int updateByPrimaryKey(SrtpHouseBase record);
}