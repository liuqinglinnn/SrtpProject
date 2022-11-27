package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.SrtpDot;
import com.Lql.SRTP.entity.SrtpDotDis;
import com.Lql.SRTP.entity.SrtpShelvesDis;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CreateDotDisDao {
    //加点
    Integer addDot(SrtpDot dotNew);

    //获取点
    SrtpDot getDot(Integer x, Integer y);

    //修改点
    Integer changeDot(SrtpDot dotNew);

    //获取点阵
    List<SrtpDot> getDotList();

    //距离加入矩阵
    Integer addDis(SrtpDotDis dotDis);

    //获取距离
    SrtpDotDis getDis(SrtpDotDis dotDis);

    //修改距离
    Integer changeDotDis(SrtpDotDis dotDisNew);

    //添加货架距离
    Integer addShelves(SrtpShelvesDis ShelvesDis);

    //获取货架距离表
    List<SrtpShelvesDis> getShelvesDis();
}
