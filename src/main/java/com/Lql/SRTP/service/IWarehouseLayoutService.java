package com.Lql.SRTP.service;

import com.Lql.SRTP.entity.*;

import java.util.List;

public interface IWarehouseLayoutService {
    //根据货物id找到订单中订购的货物
    List<Orderitem> getorderitemByPid(Integer pid);
    //计算x的周转量，周转率
    void computito(Integer pid, String starttime, String endtime) ;
    //获得x,y的相似度的值
    ShelvesDis getsimilaritynum(Integer compare1, Integer compare2);
    //计算货架的好坏程度
    Double getshelvescroe(Integer sid);
    //计算模拟退火时的好坏程度
    Double getoptimizequalitydegree(List<Optimize_product> Newlist);
    //模拟退火算法
    List<Product> optimize();
    //模拟退火返回结果
    List<Optimize_result> optimizes();



}
