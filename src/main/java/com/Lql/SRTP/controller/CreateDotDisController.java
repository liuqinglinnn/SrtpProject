package com.Lql.SRTP.controller;

import com.Lql.SRTP.entity.SrtpDot;
import com.Lql.SRTP.entity.SrtpShelvesDis;
import com.Lql.SRTP.service.ICreatedotdisService;
import com.Lql.SRTP.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Createdot")
public class CreateDotDisController extends BaseController {
    @Autowired
    private ICreatedotdisService CreateDotDisService;

    //自动打点
    @RequestMapping("/createDot")
    public JsonResult<List<SrtpDot>> createDot() {
        List<SrtpDot> data = CreateDotDisService.createDot();
        return new JsonResult<>(OK, data);
    }

    //存入m,n数据库
    @RequestMapping("/adddotdatabase")
    public JsonResult<Integer> adddotdatabase() {
        CreateDotDisService.adddotdatabase();
        return new JsonResult<>(OK, 111);
    }

    //计算并存入数据库
    @RequestMapping("/fyld")
    public JsonResult<Integer> fyld() {
        CreateDotDisService.fyld();
        return new JsonResult<>(OK, 222);
    }

    //返回货架距离矩阵
    @RequestMapping("/getShelvesdis")
    public JsonResult<List<SrtpShelvesDis>> getShelvesdis() {
        List<SrtpShelvesDis> data = CreateDotDisService.getShelvesdis();
        return new JsonResult<>(OK, data);
    }
}
