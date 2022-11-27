package com.Lql.SRTP.service;

import com.Lql.SRTP.entity.SrtpDot;
import com.Lql.SRTP.entity.SrtpShelvesDis;

import java.util.List;

public interface ICreatedotdisService {
    //自动打点
    List<SrtpDot> createDot();

    //存入m,n数据库
    void adddotdatabase();

    //计算并存入数据库
    void fyld();

    //返回货架距离矩阵
    List<SrtpShelvesDis> getShelvesdis();
}
