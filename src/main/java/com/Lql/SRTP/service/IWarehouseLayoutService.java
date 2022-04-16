package com.Lql.SRTP.service;

import com.Lql.SRTP.entity.*;

import java.util.List;

public interface IWarehouseLayoutService {
    //根据货物id找到订单中订购的货物
    List<srtporderitem> getorderitemByPid(Integer pid);

    //获得x,y的相似度的值
    similarityentity getsimilaritynum(Integer compare1, Integer compare2);

    //获得所有货物两两之间的相似度
    List<similarityentity> getallsimilaritynum();

    //计算货架的总好坏程度
    Double getshelvequalitydegree();
    //计算距离
    Double dis(Integer x1, Integer y1,Integer x2, Integer y2 );
    //计算模拟退火时的好坏程度
    Double getoptimizequalitydegree(List<productputshelvesentity> Newlist);
    //模拟退火算法
    List<productputshelvesentity> optimize();
    //模拟退火返回结果
    List<optimizeresult> optimizes();
}
