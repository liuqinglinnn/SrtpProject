package com.Lql.SRTP.controller;

import com.Lql.SRTP.entity.SrtpOrder;
import com.Lql.SRTP.entity.vo.SrtpOrderDetailVo;
import com.Lql.SRTP.entity.vo.SrtpOrderSortRateVo;
import com.Lql.SRTP.service.ISrtpOrderService;
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

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/srtp/order")
@Api(tags = "Order")
public class SrtpOrderController {

    @Autowired
    private ISrtpOrderService orderService;

    @GetMapping("/listOrders")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小"),
    })
    @ApiOperation("获取分页的订单信息")
    public JsonResult<Object> listOrders(@RequestParam Integer pageNum,
                                           @RequestParam Integer pageSize) {
        try {
            List<SrtpOrder> srtpOrders = orderService.listOrders(pageNum, pageSize);
            return JsonResult.success(srtpOrders);
        } catch (Exception e) {
            log.error("SrtpOrderController.listOrders发生异常: ", e);
            return JsonResult.failure(e.getMessage());
        }
    }

    @GetMapping("/listOrderSortRate")
    @ApiOperation("获取订单类型比率")
    public JsonResult<Object> listOrderSortRate() {
        try {
            List<SrtpOrderSortRateVo> orderSortRates = orderService.listOrderSortRate();
            return JsonResult.success(orderSortRates);
        } catch (Exception e) {
            log.error("SrtpOrderController.listOrderSortRate发生异常: ", e);
            return JsonResult.failure(e.getMessage());
        }
    }

    @GetMapping("/getOrderDetail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单号")
    })
    @ApiOperation("获取订单详细信息")
    public JsonResult<Object> getOrderDetail(@RequestParam Integer orderId) {
        try {
            SrtpOrderDetailVo orderBaseInfo = orderService.getOrderBaseInfo(orderId);
            return JsonResult.success(orderBaseInfo);
        } catch (Exception e) {
            log.error("SrtpOrderController.getOrderDetail发生异常: ", e);
            return JsonResult.failure(e.getMessage());
        }
    }
}
