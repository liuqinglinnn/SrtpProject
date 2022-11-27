package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.SrtpOrder;
import com.Lql.SRTP.entity.vo.SrtpOrderDetailVo;import com.Lql.SRTP.entity.vo.SrtpOrderSortRateVo;import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;import java.util.List;

@Mapper
public interface SrtpOrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(SrtpOrder record);

    int insertSelective(SrtpOrder record);

    SrtpOrder selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(SrtpOrder record);

    int updateByPrimaryKey(SrtpOrder record);

    List<SrtpOrder> selectByAll(SrtpOrder srtpOrder);

    List<SrtpOrderSortRateVo> selectOrderSortRate();

    SrtpOrderDetailVo selectBaseOrderInfo(@Param("orderId") Integer orderId);
}