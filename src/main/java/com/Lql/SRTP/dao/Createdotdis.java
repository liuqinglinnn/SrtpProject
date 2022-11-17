package com.Lql.SRTP.dao;

import com.Lql.SRTP.entity.Dot;
import com.Lql.SRTP.entity.Dotdis;

public interface Createdotdis {
    //加点
    Integer adddot(Dot dotnew);
    //获取点
    Dot getdot(Integer dotid);
    //距离加入矩阵
    Integer adddis(Dotdis dotdis) ;

}
