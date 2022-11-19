package com.Lql.SRTP.service;

import com.Lql.SRTP.entity.Dot;
import com.Lql.SRTP.entity.ShelvesDis;

import java.util.List;

public interface ICreatedotdisService {
    //自动打点
    List<Dot> createDot();

    //存入m,n数据库
    void adddotdatabase();

    //计算并存入数据库
    void fyld();

    //返回货架距离矩阵
    List<ShelvesDis> getShelvesdis();
}
