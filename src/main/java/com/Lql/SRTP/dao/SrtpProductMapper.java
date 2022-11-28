package com.Lql.SRTP.dao;
import java.util.List;

import com.Lql.SRTP.entity.SrtpProduct;
import com.Lql.SRTP.entity.vo.SrtpProductCardVo;import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SrtpProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SrtpProduct record);

    int insertSelective(SrtpProduct record);

    SrtpProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SrtpProduct record);

    int updateByPrimaryKey(SrtpProduct record);

    List<SrtpProduct> selectByAll(SrtpProduct srtpProduct);

    List<SrtpProduct> selectByProductName(@Param("name") String name);

    SrtpProductCardVo selectProductCardInfo(@Param("productId")Integer productId,
                                            @Param("orderId") Integer orderId);
}