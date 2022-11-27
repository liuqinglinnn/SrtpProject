package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.Dot;
import com.Lql.SRTP.entity.DotDis;
import com.Lql.SRTP.entity.ShelvesDis;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CreateDotDisDao {
    //加点
    Integer addDot(Dot dotNew);

    //获取点
    Dot getDot(Integer x, Integer y);

    //修改点
    Integer changeDot(Dot dotNew);

    //获取点阵
    List<Dot> getDotList();

    //距离加入矩阵
    Integer addDis(DotDis dotDis);

    //获取距离
    DotDis getDis(DotDis dotDis);

    //修改距离
    Integer changeDotDis(DotDis dotDisNew);

    //添加货架距离
    Integer addShelves(ShelvesDis ShelvesDis);

    //获取货架距离表
    List<ShelvesDis> getShelvesDis();
}
