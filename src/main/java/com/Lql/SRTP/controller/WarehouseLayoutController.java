package com.Lql.SRTP.controller;

import com.Lql.SRTP.dao.WarehouseLayoutDao;
import com.Lql.SRTP.entity.*;
import com.Lql.SRTP.service.IWarehouseLayoutService;
import com.Lql.SRTP.util.Jsonresult;
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

    @RequestMapping("getallproduct")
    //获得所有货物列表
    public Jsonresult<List<Product>> getAllproduct() {
        List<Product> data = WarehouseLayoutDao.getAllproduct();
        return new Jsonresult<List<Product>>(OK, data);
    }
    @RequestMapping("showincludepidorder")
    //展示含有pid的所有订单
    public Jsonresult<List<Orderitem>> showincludepidorder(Integer pid) {
        List<Orderitem> data = WarehouseLayoutService.getorderitemByPid(pid);
        return new Jsonresult<List<Orderitem>>(OK, data);
    }

    @RequestMapping("showsimiliaritynumbypid")
    //展示两个pid的相似度关系
    public Jsonresult<ShelvesDis> getsimilaritynum(Integer compare1, Integer compare2) {
        ShelvesDis data = WarehouseLayoutService.getsimilaritynum(compare1, compare2);
        return new Jsonresult<ShelvesDis>(OK, data);
    }

    @RequestMapping("showshelvequalitydegree")
    //展示货架的总好坏程度
    public Jsonresult<Double> showshelvequalitydegree() {
        Double data = WarehouseLayoutService.scoresum();
        return new Jsonresult<Double>(OK, data);
    }
    @RequestMapping("optimize")
    //模拟退火
    public Jsonresult<List<Shelves>> optimize() {
        List<Shelves> data=WarehouseLayoutService.optimize();
        return new Jsonresult<List<Shelves>>(OK, data);
    }
}
