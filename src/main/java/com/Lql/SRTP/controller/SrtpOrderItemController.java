package com.Lql.SRTP.controller;

import com.Lql.SRTP.entity.SrtpOrderItem;
import com.Lql.SRTP.entity.vo.SrtpOrderItemInOutVo;
import com.Lql.SRTP.service.ISrtpOrderItemService;
import com.Lql.SRTP.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/srtp/orderItem")
@Api(tags = "OrderItem")
public class SrtpOrderItemController {

    @Autowired
    private ISrtpOrderItemService orderItemService;

    @GetMapping("/getSumByDays")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "1 出库 2 入库 3 全部"),
            @ApiImplicitParam(name = "days", value = "天数"),
    })
    @ApiOperation("获取n天内的出库/入库/出入库总数")
    public JsonResult<Object> getSumByDays(@RequestParam Integer type,
                                           @RequestParam Integer days) {
        try {
            Integer sumDays = orderItemService.getSumByDays(type, days);
            return JsonResult.success(sumDays);
        } catch (Exception e) {
            log.error("SrtpOrderItemController.getSumDays发生异常: ", e);
            return JsonResult.failure(e.getMessage());
        }
    }

    @GetMapping("/getSumListRecentDays")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "1 出库 2 入库 3 全部"),
            @ApiImplicitParam(name = "days", value = "天数"),
    })
    @ApiOperation("获取最近n天内的每天出库/入库/出入库总数")
    public JsonResult<Object> getSumListRecentDays(@RequestParam Integer type,
                                           @RequestParam Integer days) {
        try {
            List<Integer> sumDaysList = orderItemService.getSumListRecentDays(type, days);
            return JsonResult.success(sumDaysList);
        } catch (Exception e) {
            log.error("SrtpOrderItemController.getSumListRecentDays发生异常: ", e);
            return JsonResult.failure(e.getMessage());
        }
    }

    @GetMapping("/listOrderItemsByProductId")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "商品ID"),
    })
    @ApiOperation("根据商品ID获取订单变动")
    public JsonResult<Object> listOrderItemsByProductId(@RequestParam Integer productId) {
        try {
            List<SrtpOrderItem> orderItems = orderItemService.listOrderItemsByProductId(productId);
            return JsonResult.success(orderItems);
        } catch (Exception e) {
            log.error("SrtpOrderItemController.listOrderItemsByProductId发生异常: ", e);
            return JsonResult.failure(e.getMessage());
        }
    }

    @GetMapping("/listOrderItemInOutSum")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "商品ID"),
            @ApiImplicitParam(name = "startTime", value = "开始时间"),
            @ApiImplicitParam(name = "endTime", value = "结束时间")
    })
    @ApiOperation("根据时间范围获取商品出入库数据")
    public JsonResult<Object> listOrderItemInOutSum(@RequestParam Long productId,
                                                    @RequestParam Date startTime,
                                                    @RequestParam Date endTime) {
        try {
            List<SrtpOrderItemInOutVo> orderItems =
                    orderItemService.listOrderItemsInOutSum(productId, startTime, endTime);
            return JsonResult.success(orderItems);
        } catch (Exception e) {
            log.error("SrtpOrderItemController.listOrderItemInOutSum发生异常: ", e);
            return JsonResult.failure(e.getMessage());
        }
    }
}
