package com.Lql.SRTP.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @date 2022/11/27
 * @author bngel
 */
public interface ISrtpOrderItemService {

    /**
     * 获取指定天数内的出入库总和
     * @param type 出库 1 入库 2 全部 3
     * @param days 天数
     * @return 总和
     */
    Integer getSumByDays(Integer type, Integer days);

    /**
     * 获取最近n天内的每天出入库总和
     * @param type 出库 1 入库 2 全部 3
     * @param days 天数
     * @return 总和
     */
    List<Integer> getSumListRecentDays(Integer type, Integer days);
}
