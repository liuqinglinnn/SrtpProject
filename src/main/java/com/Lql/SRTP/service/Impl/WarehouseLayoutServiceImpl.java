package com.Lql.SRTP.service.Impl;

import com.Lql.SRTP.dao.CreateDotDisDao;
import com.Lql.SRTP.dao.WarehouseLayoutDao;
import com.Lql.SRTP.entity.*;
import com.Lql.SRTP.service.IWarehouseLayoutService;
import com.Lql.SRTP.service.ex.BetterResultNotFoundException;
import com.Lql.SRTP.service.ex.OidNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WarehouseLayoutServiceImpl implements IWarehouseLayoutService {
    @Autowired
    private WarehouseLayoutDao WarehouseLayoutMapper;
 @Autowired
    private CreateDotDisDao CreatedotdisMapper;

    @Override
    public List<SrtpOrderItem> getorderitemByPid(Integer pid) {
        List<SrtpOrderItem> list = WarehouseLayoutMapper.getorderitemByPid(pid);
        //无香烟数据的异常
        if (list == null) {
            throw new OidNotFoundException("香烟数据不存在");
        }
        return list;
    }

    //计算x的周转量，周转率,存入数据库
    @Override
    public void computito(Integer pid, String starttime, String endtime) {
        List<SrtpOrderItem> orderlist = getorderitemByPid(pid);
        //获取一个季度初末库存
        SrtpOrderItem startitem = WarehouseLayoutMapper.gettimerest(starttime, pid);
        SrtpOrderItem enditem = WarehouseLayoutMapper.gettimerest(endtime, pid);
        Integer startnum = startitem.getPrest();
        Integer endnum = enditem.getPrest();
        Double avenum = (double) (startnum + endnum) / 2;
        //获取一个季度的出库量
        Integer outnum = 0;
        for (int i = 0; i < orderlist.size(); i++) {
            if (orderlist.get(i).getPstate() == 1) {
                outnum += orderlist.get(i).getPnum();
            }
        }
        //计算ito
        Double iton = outnum / avenum;
        //存入数据库
        Double itom = iton * WarehouseLayoutMapper.getproductByPid(pid).getPrice();
        WarehouseLayoutMapper.changeproduct(iton, itom, pid);
        SrtpHouseBase housebase = WarehouseLayoutMapper.gethousebase(1);
    }

    //两个货物的相关性，输入两者货物id，获取订单中的数量，计算相关性，存入数据库，返回结果
    @Override
    public SrtpShelvesDis getsimilaritynum(Integer compare1, Integer compare2) {
        //获取共同出现的itemlist
        List<SrtpOrderItem> itemlist = WarehouseLayoutMapper.gettogetheritem(compare1, compare2);
        Double num = 0.0;
        Double k = 1.0;//系数
        for (int i = 0; i < itemlist.size(); i = i + 2) {
            Integer xy = itemlist.get(i).getPnum() * itemlist.get(i + 1).getPnum();
            num = num + Math.sqrt(1 + k * xy);
        }

    WarehouseLayoutMapper.updatashelvesdis(compare1, compare2, num);
        SrtpShelvesDis simresult = WarehouseLayoutMapper.getshelvesdis(compare1, compare2);
        return simresult;
    }
    //计算货架的好坏程度
    @Override
    public Double getshelvescroe(Integer sid) {
        SrtpShelves shelve = WarehouseLayoutMapper.getshelvesBysid(sid);

        //无货物为-100
        if (shelve.getPid() == null) {
            return -100.0;
        }
        //计算scoresum,存入数据库，作为返回结果
        else {
            SrtpProduct product = WarehouseLayoutMapper.getproductByPid(shelve.getPid());
            List<SrtpProduct> productlist = WarehouseLayoutMapper.getAllproduct();
            SrtpHouseBase house = WarehouseLayoutMapper.gethousebase(1);
            double score, score1 = 0.0, score2 = 0.0;
            double k1 = 1.0, k2 = 1.0, k3 = 1.0, k4 = 1.0, k5 = 1.0, c1 = 1.0, c2 = 1.0;
            Integer chux = 0, chuy = 0, rux = 100, ruy = 100;
            for (int i = 0; i < productlist.size(); i++) {
                SrtpShelvesDis tem = getsimilaritynum(product.getId(), productlist.get(i).getId());
                score1 += k1 * tem.getNum1() / (k2 * tem.getDis() + c1);
            }
            SrtpDotDis temdis1 = new SrtpDotDis(chux, chuy, shelve.getSx2(), shelve.getSy2(), null);
            SrtpDotDis temdis2 = new SrtpDotDis(rux, ruy, shelve.getSx2(), shelve.getSy2(), null);
            Integer dischurusum = CreatedotdisMapper.getDis(temdis1).getDis() + CreatedotdisMapper.getDis(temdis2).getDis();
            score2 = score2 + k3 * product.getIton() / house.getIton() + k4 * product.getItom() / house.getItom();
            score2 = score2 / (k5 * dischurusum + c2);
            score = score1 + score2;
            return score;
        }
    }

    @Override
    //总好坏程度
    public Double scoresum() {
        Double scoresum = 0.0;
        List<SrtpProduct> allproduct = WarehouseLayoutMapper.getAllproduct();
        for (int i = 0; i < allproduct.size(); i++) {
            scoresum += getshelvescroe(allproduct.get(i).getSid());
        }
        return scoresum;
    }

    //计算模拟退火时的好坏程度
    @Override
    public Double getoptimizequalitydegree(List<SrtpShelves> newshelveslist) {
        Double scoresum = 0.0;
        SrtpHouseBase house = WarehouseLayoutMapper.gethousebase(1);
        //循环所有x
        for (int i = 0; i < newshelveslist.size(); i++) {
            Integer sidi = newshelveslist.get(i).getId();
            SrtpShelves shelvesnow = newshelveslist.get(i);
            Double score = 0.0;
            Double score1 = 0.0;
            Double score2 = 0.0;
            //无货物为-100
            if (sidi == null) {
                score = -100.0;
            }
            //有货物
            else {   //获取对每个y的score1
                double k1 = 1.0, k2 = 1.0, k3 = 1.0, k4 = 1.0, k5 = 1.0, c1 = 1.0, c2 = 1.0;
                Integer chux = 0, chuy = 0, rux = 100, ruy = 100;
                SrtpProduct productnow = WarehouseLayoutMapper.getproductByPid(shelvesnow.getPid());
                SrtpDotDis temdis1 = new SrtpDotDis(chux, chuy, shelvesnow.getSx2(), shelvesnow.getSy2(), null);
                SrtpDotDis temdis2 = new SrtpDotDis(rux, ruy, shelvesnow.getSx2(), shelvesnow.getSy2(), null);
                for (int j = 0; j < newshelveslist.size(); j++) {
                    Integer sidj = newshelveslist.get(j).getId();
                    SrtpShelvesDis tem =WarehouseLayoutMapper.getshelvesdis(sidi,sidj);
                    score1 += k1 * tem.getNum1() / (k2 * tem.getDis() + c1);
                }
                //获取score2
                Integer dischurusum = CreatedotdisMapper.getDis(temdis1).getDis() + CreatedotdisMapper.getDis(temdis2).getDis();
                score2 = score2 + k3 * productnow.getIton() / house.getIton() + k4 * productnow.getItom() / house.getItom();
                score2 = score2 / (k5 * dischurusum + c2);
                score = score1 + score2;
            }
            scoresum += score;
        }
        return scoresum;
    }

    //模拟退火算法
    @Override
    public List<SrtpShelves> optimize() {
        double T = 100;//初始温度（半径）
        double del = 0.99;//退火速率
        double lim = 1;//最低限度
        int j, k, l, m;
        double i;
        //原来数据
        List<SrtpShelves> PSlist = WarehouseLayoutMapper.getAllshelves();
        double PSdegree = scoresum();
        //退火数据
        List<SrtpShelves> Newlist = WarehouseLayoutMapper.getAllshelves();
        double Newlistdegree;
        //暂时更优解数据
        List<SrtpShelves> Bestlist = WarehouseLayoutMapper.getAllshelves();
        double Bestdegree = scoresum();
        //开始退火
        for (i = T; i >= lim; i = del * i) {
            //每次退火更换所有货架的商品顺序
            for (j = 0; j < Newlist.size(); j++) {
                //圆心物品
                int jx = Newlist.get(j).getSx2();
                int jy = Newlist.get(j).getSy2();
                //符合半径范围的物品
                List<SrtpShelves> temlist = new ArrayList<>();
                for (k = 0; k < Newlist.size(); k++) {
                    //符合条件的列表
                    Integer dis = WarehouseLayoutMapper.getshelvesdis(Newlist.get(j).getId(), Newlist.get(k).getId()).getDis();
                    if (dis < i) {
                        temlist.add(Newlist.get(k));
                    }
                }
                //获取一个随机列表
                Random rand = new Random();
                SrtpShelves ranentity = temlist.get(rand.nextInt(temlist.size()));
                //交换位置
                for (l = 0; l < Newlist.size(); l++) {
                    //Newlist(l)是随机类Newlist(j)是圆心类
                    if (Newlist.get(l).getPid().equals(ranentity.getPid())) {
                        //中间类
                        int p = Newlist.get(l).getPid();
                        Newlist.get(l).setPid(Newlist.get(j).getPid());
                        Newlist.get(j).setPid(p);
                    }
                }
            }
            //换完顺序后开始比较好坏程度
            Newlistdegree = getoptimizequalitydegree(Newlist);
            if (Newlistdegree > Bestdegree) {
                Bestdegree = Newlistdegree;
                //替换最优解
                for (m = 0; m < Newlist.size(); m++) {
                    Bestlist.set(m, Newlist.get(m));
                }
            }
        }
        if (Bestdegree <= PSdegree) {
            throw new BetterResultNotFoundException("未找到更优解请再试一次");
        }
        return Bestlist;
    }
}