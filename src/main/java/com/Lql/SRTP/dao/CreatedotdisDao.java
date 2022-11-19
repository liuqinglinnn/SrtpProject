package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.Dot;
import com.Lql.SRTP.entity.Dotdis;
import com.Lql.SRTP.entity.ShelvesDis;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CreatedotdisDao {
    //加点
    Integer adddot(Dot dotnew);

    //获取点
    Dot getdot(Integer x, Integer y);

    //修改点
    Integer changedot(Dot dotnew);

    //获取点阵
    List<Dot> getdotlist();

    //距离加入矩阵
    Integer adddis(Dotdis dotdis);

    //获取距离
    Dotdis getdis(Dotdis dotdis);

    //修改距离
    Integer changedotdis(Dotdis dotdisnew);

    //添加货架距离
    Integer addshelves(ShelvesDis ShelvesDis);

    //获取货架距离表
    List<ShelvesDis> getshelvesdis();
}
