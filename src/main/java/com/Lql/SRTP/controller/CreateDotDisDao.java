package com.Lql.SRTP.controller;

import com.Lql.SRTP.entity.Dot;
import com.Lql.SRTP.entity.ShelvesDis;
import com.Lql.SRTP.service.ICreatedotdisService;
import com.Lql.SRTP.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Createdot")
public class CreateDotDisDao extends BaseController {
    @Autowired
    private ICreatedotdisService CreateDotDisService;

    //自动打点
    @RequestMapping("/createDot")
    public JsonResult<List<Dot>> createDot() {
        List<Dot> data = CreateDotDisService.createDot();
        return new JsonResult<List<Dot>>(OK, data);
    }

    //存入m,n数据库
    @RequestMapping("/adddotdatabase")
    public JsonResult<Integer> adddotdatabase() {
        CreateDotDisService.adddotdatabase();
        return new JsonResult<Integer>(OK, 111);
    }

    //计算并存入数据库
    @RequestMapping("/fyld")
    public JsonResult<Integer> fyld() {
        CreateDotDisService.fyld();
        return new JsonResult<Integer>(OK, 222);
    }

    //返回货架距离矩阵
    @RequestMapping("/getShelvesdis")
    public JsonResult<List<ShelvesDis>> getShelvesdis() {
        List<ShelvesDis> data = CreateDotDisService.getShelvesdis();
        return new JsonResult<List<ShelvesDis>>(OK, data);
    }
}
