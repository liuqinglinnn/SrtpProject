package com.Lql.SRTP.dao;
import java.util.Date;

import com.Lql.SRTP.entity.SrtpOrderItem;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;import java.util.List;

@Mapper
public interface SrtpOrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SrtpOrderItem record);

    int insertSelective(SrtpOrderItem record);

    SrtpOrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SrtpOrderItem record);

    int updateByPrimaryKey(SrtpOrderItem record);

    Integer getSumByDays(@Param("type") Integer type,
                         @Param("days") Integer days);

    List<Integer> getSumListRecentDays(@Param("type") Integer type,
                                       @Param("days") Integer days);

    List<SrtpOrderItem> selectByAll(SrtpOrderItem srtpOrderItem);


}