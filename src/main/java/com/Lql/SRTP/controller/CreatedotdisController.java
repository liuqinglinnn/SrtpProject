package com.Lql.SRTP.controller;

import com.Lql.SRTP.entity.Dot;
import com.Lql.SRTP.entity.ShelvesDis;
import com.Lql.SRTP.service.ICreatedotdisService;
import com.Lql.SRTP.util.Jsonresult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("Createdot")
public class CreatedotdisController extends BaseController {
    @Autowired
    private ICreatedotdisService CreatedotdisService ;

    //自动打点
    @PostMapping("createDot")
    public Jsonresult<List<Dot>> createDot() {
        List<Dot> data = CreatedotdisService.createDot();
        return new Jsonresult<List<Dot>>(OK, data);
    }

    //存入m,n数据库
    @PostMapping("adddotdatabase")
    public Jsonresult<Integer> adddotdatabase() {
        CreatedotdisService.adddotdatabase();
        return new Jsonresult<Integer>(OK, 111);
    }

    //计算并存入数据库
    @PostMapping("fyld")
    public Jsonresult<Integer> fyld() {
        log.info("---------------------------13");
        CreatedotdisService.fyld();
        log.info("---------------------------14");
        return new Jsonresult<Integer>(OK, 222);
    }

    //返回货架距离矩阵
    @GetMapping("getShelvesdis")
    public Jsonresult<List<ShelvesDis>> getShelvesdis() {
        List<ShelvesDis> data = CreatedotdisService.getShelvesdis();
        return new Jsonresult<List<ShelvesDis>>(OK, data);
    }
}
