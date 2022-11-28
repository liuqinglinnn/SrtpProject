package com.Lql.SRTP.controller;

import com.Lql.SRTP.dao.WarehouseLayoutDao;
import com.Lql.SRTP.entity.*;
import com.Lql.SRTP.service.IWarehouseLayoutService;
import com.Lql.SRTP.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("WarehouseLayout")
public class WarehouseLayoutController extends BaseController {
    @Autowired
    private IWarehouseLayoutService WarehouseLayoutService;
    @Autowired
    private WarehouseLayoutDao WarehouseLayoutDao;

    @RequestMapping("/getallproduct")
    //获得所有货物列表
    public JsonResult<List<SrtpProduct>> getAllproduct() {
        List<SrtpProduct> data = WarehouseLayoutDao.getAllproduct();
        return new JsonResult<List<SrtpProduct>>(OK, data);
    }
    @RequestMapping("/showincludepidorder")
    //展示含有pid的所有订单
    public JsonResult<List<SrtpOrderItem>> showincludepidorder(Integer pid) {
        List<SrtpOrderItem> data = WarehouseLayoutService.getorderitemByPid(pid);
        return new JsonResult<List<SrtpOrderItem>>(OK, data);
    }

    @RequestMapping("/showsimiliaritynumbypid")
    //展示两个pid的相似度关系
    public JsonResult<SrtpShelvesDis> getsimilaritynum(Integer compare1, Integer compare2) {
        SrtpShelvesDis data = WarehouseLayoutService.getsimilaritynum(compare1, compare2);
        return new JsonResult<SrtpShelvesDis>(OK, data);
    }

    @RequestMapping("/showshelvequalitydegree")
    //展示货架的总好坏程度
    public JsonResult<Double> showshelvequalitydegree() {
        Double data = WarehouseLayoutService.scoresum();
        return new JsonResult<Double>(OK, data);
    }
    @RequestMapping("/optimize")
    //模拟退火
    public JsonResult<List<SrtpShelves>> optimize() {
        List<SrtpShelves> data=WarehouseLayoutService.optimize();
        return new JsonResult<List<SrtpShelves>>(OK, data);
    }
}
