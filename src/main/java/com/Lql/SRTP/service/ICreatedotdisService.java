package com.Lql.SRTP.service;

import com.Lql.SRTP.entity.Dot;
import com.Lql.SRTP.entity.Dotdis;
import com.Lql.SRTP.entity.Shelves;

import java.util.List;

public interface ICreatedotdisService {
    //自动打点
    List<Dot>createDot();
    //存入m,n数据库
    void adddotdatabase();
    //计算并存入数据库
    void djstra();
    //返回结果矩阵
    List<Dotdis>getDotdis();
}
