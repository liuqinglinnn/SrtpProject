package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.SrtpOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SrtpOrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(SrtpOrder record);

    int insertSelective(SrtpOrder record);

    SrtpOrder selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(SrtpOrder record);

    int updateByPrimaryKey(SrtpOrder record);
}