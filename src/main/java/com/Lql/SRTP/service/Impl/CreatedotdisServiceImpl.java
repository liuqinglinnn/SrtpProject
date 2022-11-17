package com.Lql.SRTP.service.Impl;

import com.Lql.SRTP.dao.Createdotdis;
import com.Lql.SRTP.dao.WarehouseLayoutDao;
import com.Lql.SRTP.entity.Dot;
import com.Lql.SRTP.entity.Dotdis;
import com.Lql.SRTP.entity.Optimize_similiarity;
import com.Lql.SRTP.entity.Shelves;
import com.Lql.SRTP.service.ICreatedotdisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreatedotdisServiceImpl implements ICreatedotdisService {
    @Autowired
    private Createdotdis CreatedotdisMapper;
    @Autowired
    private WarehouseLayoutDao WarehouseLayoutMapper;
    @Override
    public List<Dot> createDot(){
    //删除货架障碍物的点
    List<Shelves> slist = WarehouseLayoutMapper.getAllshelves();
List<Dot> dotlist=new ArrayList<>();

    }
    @Override
    public void adddotdatabase(){}
    @Override
    public void djstra(){}
    @Override
    public List<Dotdis>getDotdis()

}
