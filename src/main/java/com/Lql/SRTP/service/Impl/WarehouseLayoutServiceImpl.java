package com.Lql.SRTP.service.Impl;

import com.Lql.SRTP.dao.WarehouseLayoutDao;
import com.Lql.SRTP.entity.*;
import com.Lql.SRTP.service.IWarehouseLayoutService;
import com.Lql.SRTP.service.ex.BetterResultNotFoundException;
import com.Lql.SRTP.service.ex.OidNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class WarehouseLayoutServiceImpl implements IWarehouseLayoutService {
    @Autowired
    private WarehouseLayoutDao WarehouseLayoutMapper;

    @Override
    public List<Orderitem> getorderitemByPid(Integer pid) {
        List<Orderitem> list = WarehouseLayoutMapper.getorderitemByPid(pid);
        //无香烟数据的异常
        if (list == null) {
            throw new OidNotFoundException("香烟数据不存在");
        }
        return list;
    }

    //计算x的周转量，周转率,存入数据库
    @Override
    public void computito(Integer pid, String starttime, String endtime) {
        List<Orderitem> orderlist = getorderitemByPid(pid);
        //获取一个季度初末库存
//        Orderitem startitem = WarehouseLayoutMapper.gettimerest(starttime, pid);
//        Orderitem enditem = WarehouseLayoutMapper.gettimerest(endtime, pid);
        //       Integer startnum = startitem.getPrest();
//        Integer endnum = enditem.getPrest();
//        Double avenum = (double) (startnum + endnum) / 2;
        //获取一个季度的出库量
        Integer outnum = 0;
        for (int i = 0; i < orderlist.size(); i++) {
            //if (orderlist.get(i).getPstate() == 1) {
            outnum += orderlist.get(i).getPnum();
            //   }
        }
        //计算ito
        //     Double iton = outnum / avenum;
        Double iton = outnum / 50.0;
        //存入数据库
        Double itom = iton * WarehouseLayoutMapper.getproductByPid(pid).getPrice();
        WarehouseLayoutMapper.changeproduct(iton, itom, pid);
        Housebase housebase = WarehouseLayoutMapper.gethousebase(1);
    }

    //两个货物的相关性，输入两者货物id，获取订单中的数量，计算相关性，存入数据库，返回结果
    @Override
    public ShelvesDis getsimilaritynum(Integer compare1, Integer compare2) {
        //获取共同出现的itemlist
        List<Orderitem> itemlist = WarehouseLayoutMapper.gettogetheritem(compare1, compare2);
        Double num = 0.0;
        Double k = 1.0;//系数
        log.info(itemlist.toString());
        for (int i = 0; i < itemlist.size(); ) {
            Integer xy = itemlist.get(i).getPnum() * itemlist.get(i + 1).getPnum();
            num = num + Math.sqrt(1 + k * xy);
            i = i + 2;
        }

        WarehouseLayoutMapper.updatashelvesdis(compare1, compare2, num);
        ShelvesDis simresult = WarehouseLayoutMapper.getshelvesdis(compare1, compare2);
        return simresult;
    }

    //计算货架的好坏程度
    @Override
    public Double getshelvescroe(Integer sid) {
        Shelves shelve = WarehouseLayoutMapper.getshelvesBysid(sid);

        //无货物为-100
        if (shelve.getPid() == null) {

            return -100.0;
        }
        //计算scoresum,存入数据库，作为返回结果
        else {
            Product product = WarehouseLayoutMapper.getproductByPid(shelve.getPid());
            List<Product> productlist = WarehouseLayoutMapper.getAllproduct();
            Housebase house = WarehouseLayoutMapper.gethousebase(1);
            double score, score1 = 0.0, score2 = 0.0;
            double k1 = 1.0, k2 = 1.0, k3 = 1.0, k4 = 1.0, k5 = 1.0, c1 = 1.0, c2 = 1.0;
            Integer chux = 0, chuy = 0, rux = 100, ruy = 100;
            log.info("222");
            for (int i = 0; i < productlist.size(); i++) {
                log.info("333");
                if (productlist.get(i).getId() != product.getId()) {

                    ShelvesDis tem = getsimilaritynum(product.getId(), productlist.get(i).getId());
                    if (tem != null)
                        score1 += k1 * tem.getNum1() / (k2 * tem.getDis() + c1);
                }

            }
            Dotdis temdis1 = new Dotdis(chux, chuy, shelve.getSx2(), shelve.getSy2(), null);
            Dotdis temdis2 = new Dotdis(rux, ruy, shelve.getSx2(), shelve.getSy2(), null);
            //出入口距离
            Integer dischurusum = WarehouseLayoutMapper.getshelvesdis(shelve.getId(), 15).getDis();
            score2 = score2 + k3 * product.getIton() / house.getIton() + k4 * product.getItom() / house.getItom();
            score2 = score2 / (k5 * dischurusum + c2);
            score = score1 + score2;
            WarehouseLayoutMapper.changeshelvessv(sid, score);
            return score;
        }
    }

    @Override
    //总好坏程度
    public Double scoresum() {
        Double scoresum = 0.0;
        List<Product> allproduct = WarehouseLayoutMapper.getAllproduct();
        for (int i = 0; i < allproduct.size(); i++) {
            scoresum += getshelvescroe(allproduct.get(i).getSid());
        }
        return scoresum;
    }

    //计算模拟退火时的好坏程度
    @Override
    public Double getoptimizequalitydegree(List<Shelves> newshelveslist) {
        Double scoresum = 0.0;
        Housebase house = WarehouseLayoutMapper.gethousebase(1);
        //循环所有x
        for (int i = 0; i < newshelveslist.size(); i++) {
            Integer sidi = newshelveslist.get(i).getId();
            Shelves shelvesnow = newshelveslist.get(i);
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
                Product productnow = WarehouseLayoutMapper.getproductByPid(shelvesnow.getPid());
                Dotdis temdis1 = new Dotdis(chux, chuy, shelvesnow.getSx2(), shelvesnow.getSy2(), null);
                Dotdis temdis2 = new Dotdis(rux, ruy, shelvesnow.getSx2(), shelvesnow.getSy2(), null);
                for (int j = 0; j < newshelveslist.size(); j++) {
                    Integer sidj = newshelveslist.get(j).getId();
                    ShelvesDis tem = WarehouseLayoutMapper.getshelvesdis(sidi, sidj);
                    if(tem!=null&&tem.getNum1()!=null)

                    score1 += k1 * tem.getNum1() / (k2 * tem.getDis() + c1);
                }
                //获取score2
                Integer dischurusum=100;
                if(WarehouseLayoutMapper.getshelvesdis(shelvesnow.getId(), 15)!=null){
                     dischurusum = WarehouseLayoutMapper.getshelvesdis(shelvesnow.getId(), 15).getDis();
                }

                if(productnow!=null){
                    score2 = score2 + k3 * productnow.getIton() / house.getIton() + k4 * productnow.getItom() / house.getItom();
                    score2 = score2 / (k5 * dischurusum + c2);
                }

                score = score1 + score2;
            }
            scoresum += score;
        }
        return scoresum;
    }

    //模拟退火算法
    @Override
    public List<Shelves> optimize() {
        double T = 50;//初始温度（半径）
        double del = 0.99;//退火速率
        double lim = 1;//最低限度
        int j, k, l, m;
        double i;
        //原来数据
        List<Shelves> PSlist = WarehouseLayoutMapper.getAllshelves();
        double PSdegree = scoresum();
        //退火数据
        List<Shelves> Newlist = WarehouseLayoutMapper.getAllshelves();
        double Newlistdegree;
        //暂时更优解数据
        List<Shelves> Bestlist = WarehouseLayoutMapper.getAllshelves();
        double Bestdegree = scoresum();
        //开始退火
        for (i = T; i >= lim; i = del * i) {
            //每次退火更换所有货架的商品顺序
            for (j = 0; j < Newlist.size(); j++) {
                //圆心物品
                int jx = Newlist.get(j).getSx2();
                int jy = Newlist.get(j).getSy2();
                //符合半径范围的物品
                List<Shelves> temlist = new ArrayList<Shelves>();
                for (k = 0; k < Newlist.size(); k++) {
                    //符合条件的列表
                    ShelvesDis dist = WarehouseLayoutMapper.getshelvesdis(Newlist.get(j).getId(), Newlist.get(k).getId());
                    Integer dis = 0;
                    if (dist != null)
                        dis = dist.getDis();
                    if (dis < i) {
                        temlist.add(Newlist.get(k));
                    }
                }
                //获取一个随机列表
                Random rand = new Random();
                Shelves ranentity = temlist.get(rand.nextInt(temlist.size()));
                //交换位置
                for (l = 0; l < Newlist.size(); l++) {
                    //Newlist(l)是随机类Newlist(j)是圆心类
                    if(ranentity.getPid()==null||Newlist.get(l).getPid()==null){
                        //入口不管
                    }
                   else if(Newlist.get(l).getPid().equals(ranentity.getPid())) {
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