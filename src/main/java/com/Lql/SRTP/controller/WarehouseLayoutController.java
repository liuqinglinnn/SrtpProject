package com.Lql.SRTP.controller;

import com.Lql.SRTP.entity.Shelves;
import com.Lql.SRTP.entity.ShelvesDis;
import com.Lql.SRTP.service.IWarehouseLayoutService;
import com.Lql.SRTP.util.Jsonresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("WarehouseLayout")
public class WarehouseLayoutController extends BaseController {
    @Autowired
    private IWarehouseLayoutService WarehouseLayoutService;

    @GetMapping("computito")
    //计算x的周转量，周转率
    public Jsonresult<Integer> getsimilaritynum(Integer pid, String starttime, String endtime) {
        WarehouseLayoutService.computito(pid, starttime, endtime);
        return new Jsonresult<Integer>(OK, 222);
    }

    //获得x,y的相似度的值
    @GetMapping("getsimilaritynum")
    public Jsonresult<ShelvesDis> getsimilaritynum(Integer compare1, Integer compare2) {
        ShelvesDis data = WarehouseLayoutService.getsimilaritynum(compare1, compare2);
        return new Jsonresult<ShelvesDis>(OK, data);
    }

    //计算货架的好坏程度
    @GetMapping("getshelvescroe")
    public Jsonresult<Double> getshelvescroe(Integer sid) {
        Double data = WarehouseLayoutService.getshelvescroe(sid);
        return new Jsonresult<Double>(OK, data);
    }

    @GetMapping("showshelvequalitydegree")
    //展示货架的总好坏程度
    public Jsonresult<Double> showshelvequalitydegree() {
        Double data = WarehouseLayoutService.scoresum();
        return new Jsonresult<Double>(OK, data);
    }

    @GetMapping("optimize")
    //模拟退火
    public Jsonresult<List<Shelves>> optimize() {
        List<Shelves> data = WarehouseLayoutService.optimize();
        return new Jsonresult<List<Shelves>>(OK, data);
    }
}
