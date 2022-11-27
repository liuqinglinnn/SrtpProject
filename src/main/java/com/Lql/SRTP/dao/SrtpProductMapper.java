package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.SrtpProduct;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SrtpProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SrtpProduct record);

    int insertSelective(SrtpProduct record);

    SrtpProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SrtpProduct record);

    int updateByPrimaryKey(SrtpProduct record);
}