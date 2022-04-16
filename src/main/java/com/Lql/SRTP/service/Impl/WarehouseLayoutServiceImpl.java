package com.Lql.SRTP.service.Impl;

import com.Lql.SRTP.dao.WarehouseLayoutDao;
import com.Lql.SRTP.entity.*;
import com.Lql.SRTP.service.IWarehouseLayoutService;
import com.Lql.SRTP.service.ex.BetterResultNotFound;
import com.Lql.SRTP.service.ex.OidNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class WarehouseLayoutServiceImpl implements IWarehouseLayoutService {
    @Autowired
    private WarehouseLayoutDao WarehouseLayoutMapper;

    //无香烟数据的异常
    @Override
    public List<srtporderitem> getorderitemByPid(Integer pid) {
        List<srtporderitem> list = WarehouseLayoutMapper.getorderitemByPid(pid);
        if (list == null) {
            throw new OidNotFoundException("香烟数据不存在");
        }
        return list;
    }

    //比较两个货物的相似度，输入两者货物id，获取订单中的数量，计算相关性，返回结果
    @Override
    public similarityentity getsimilaritynum(Integer compare1, Integer compare2) {
        List<srtporderitem> compare1list = getorderitemByPid(compare1);
        List<srtporderitem> compare2list = getorderitemByPid(compare2);
        double ai, e, sume = 0.0, min, max, sum = 0.0;
        //sum为分子的和，sume为分母的和，maxmin为两者中的较大较小值，e为单个订单中二者的和，ai为比值
        for (int i = 0; i < compare1list.size(); i++) {
            srtporderitem com1 = compare1list.get(i);
            srtporderitem com2 = compare2list.get(i);
            max = com1.getPnum() >= com2.getPnum() ? com1.getPnum() : com2.getPnum();
            min = com1.getPnum() >= com2.getPnum() ? com2.getPnum() : com1.getPnum();
            if (max == 0 || min == 0) {
                ai = 0.0;
            } else {
                ai = min / max;
            }
            e = com1.getPnum() + com2.getPnum();
            sum = sum + e * Math.pow(ai - 1, 2);
            sume = sume + e;
        }
        double simnum = sum / sume;
        similarityentity simresult = new similarityentity();
        simresult.setCompare1(compare1);
        simresult.setCompare2(compare2);
        simresult.setSimnum(simnum);
        simresult.setSume(sume);
        return simresult;
    }

    //获得所有货物两两之间的相似度
    @Override
    public List<similarityentity> getallsimilaritynum() {
        List<similarityentity> resultlist = new ArrayList<similarityentity>();
        List<srtpproduct> pidlist = WarehouseLayoutMapper.getAllproduct();
        for (int j = 0; j < pidlist.size(); j++) {
            for (int k = j + 1; k < pidlist.size(); k++) {
                similarityentity f = getsimilaritynum(pidlist.get(j).getId(), pidlist.get(k).getId());
                //计算好坏程度
                double c = 0.03;//常数c防爆
                double s = f.getSimnum();//相似度s
                double sume = f.getSume();//jk的和
                double xj = (double) pidlist.get(j).getX();
                double xk = (double) pidlist.get(k).getX();
                double yj = (double) pidlist.get(j).getY();
                double yk = (double) pidlist.get(k).getY();
                double dis = Math.sqrt(Math.pow(xj - xk, 2) + Math.pow(yj - yk, 2));//二者在仓库的距离
                double degree = sume / ((s + c) * dis);
                f.setSimnum(degree);
                resultlist.add(f);
            }
        }
        return resultlist;
    }

    //计算货架的总好坏程度
    @Override
    public Double getshelvequalitydegree() {
        double qualitydegree = 0.0;
        double valuesum = 0.0;
        double numi = 0.0;
        double vi = 0.0;
        double similitysum = 0.0;
        List<srtpproduct> productlist = WarehouseLayoutMapper.getAllproduct();
        List<similarityentity> similaritylist = getallsimilaritynum();
        //计算相似度的和
        for (int j = 0; j < similaritylist.size(); j++) {
            similitysum += similaritylist.get(j).getSimnum();
        }
        //计算货架价值的和
        for (int i = 0; i < productlist.size(); i++) {
            numi = 0.0;
            //根据货物id求出订单中货物的总和
            int idx = productlist.get(i).getId();//货物id
            int sid = productlist.get(i).getSid();//货架id
            List<srtporderitem> productxlist = getorderitemByPid(idx);
            for (int k = 0; k < productxlist.size(); k++) {
                numi += productxlist.get(k).getPnum();
            }
            //根据货架id求出当前货架总价值
            srtpshelves srtpshelvex = WarehouseLayoutMapper.getshelveBysid(sid);
            vi = srtpshelvex.getSv();
            valuesum += vi * numi;
        }
        //总好坏程度
        qualitydegree = similitysum + valuesum / 10;

        return qualitydegree;
    }

    //计算距离
    @Override
    public Double dis(Integer x1, Integer y1, Integer x2, Integer y2) {
        double dis = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));//二者在仓库的距离
        return dis;
    }

    //计算模拟退火时的好坏程度
    @Override
    public Double getoptimizequalitydegree(List<productputshelvesentity> Newlist) {
        double qualitydegree = 0.0;
        double valuesum = 0.0;
        double numi = 0.0;
        double vi = 0.0;
        double similitysum = 0.0;
        //计算退火算法中物品两两之间的相似度
        List<similarityentity> similaritylist = new ArrayList<similarityentity>();
        for (int j = 0; j < Newlist.size(); j++) {
            for (int k = j + 1; k < Newlist.size(); k++) {
                similarityentity f = getsimilaritynum(Newlist.get(j).getPid(), Newlist.get(k).getPid());
                //计算好坏程度
                double c = 0.03;//常数c防爆
                double s = f.getSimnum();//相似度s
                double sume = f.getSume();//jk的和
                double xj = (double) Newlist.get(j).getX();
                double xk = (double) Newlist.get(k).getX();
                double yj = (double) Newlist.get(j).getY();
                double yk = (double) Newlist.get(k).getY();
                double dis = Math.sqrt(Math.pow(xj - xk, 2) + Math.pow(yj - yk, 2));//二者在仓库的距离
                double degree = sume / ((s + c) * dis);
                f.setSimnum(degree);
                similaritylist.add(f);
            }
        }
        //计算相似度的和
        for (int j = 0; j < similaritylist.size(); j++) {
            similitysum += similaritylist.get(j).getSimnum();
        }
        //计算货架价值的和
        for (int i = 0; i < Newlist.size(); i++) {
            numi = 0.0;
            //根据货物id求出订单中货物的总和
            int idx = Newlist.get(i).getPid();//货物id
            int sid = Newlist.get(i).getSid();//货架id
            List<srtporderitem> productxlist = getorderitemByPid(idx);
            for (int k = 0; k < productxlist.size(); k++) {
                numi += productxlist.get(k).getPnum();
            }
            //根据货架id求出当前货架总价值
            srtpshelves srtpshelvex = WarehouseLayoutMapper.getshelveBysid(sid);
            vi = srtpshelvex.getSv();
            valuesum += vi * numi;
        }
        //总好坏程度
        qualitydegree = similitysum + valuesum / 10;
        return qualitydegree;
    }


    //模拟退火算法
    @Override
    public List<productputshelvesentity> optimize() {
        double T = 500;//初始温度（半径）
        double del = 0.99;//退火速率
        double lim = 1;//最低限度
        int j, k, l,m;
        double i;
        //原来数据
        List<productputshelvesentity> PSlist = WarehouseLayoutMapper.getPSrealtionship();
        double PSdegree = getshelvequalitydegree();
        //退火数据
        List<productputshelvesentity> Newlist = WarehouseLayoutMapper.getPSrealtionship();
        double Newlistdegree;
        //暂时更优解数据
        List<productputshelvesentity> Bestlist =WarehouseLayoutMapper.getPSrealtionship();
        double Bestdegree = getshelvequalitydegree();
        //开始退火
     for (i = T; i >= lim; i = del * i) {
            //每次退火更换所有货架的商品顺序
            for (j = 0; j < Newlist.size(); j++) {
                //圆心物品
                int jx = Newlist.get(j).getX();
                int jy = Newlist.get(j).getY();
                //符合半径范围的物品
                List<productputshelvesentity> temlist = new ArrayList<productputshelvesentity>();
                for (k = 0; k < Newlist.size(); k++) {
                    //符合条件的列表
                    int kx = Newlist.get(k).getX();
                    int ky = Newlist.get(k).getY();
                    double dis = dis(jx, jy, kx, ky);
                    if (dis < i) {
                        temlist.add(Newlist.get(k));
                    }
                }
                //获取一个随机列表
                Random rand = new Random();
                productputshelvesentity ranentity = temlist.get(rand.nextInt(temlist.size()));
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
                Bestdegree=Newlistdegree;
                //替换最优解
                for (m = 0; m < Newlist.size(); m++) {
                    Bestlist.set(m,Newlist.get(m));
                }
            }
        }
        if(Bestdegree<=PSdegree)
        { throw new BetterResultNotFound("未找到更优解请再试一次");}
      return Bestlist;
    }
    @Override
   public List<optimizeresult> optimizes(){
        //模拟退火结果
        List<productputshelvesentity> list = optimize();
        //模拟退火结果换成产品列表
        List<optimizeresult>reslist=new ArrayList<>();
        int i;
        for(i=0;i<list.size();i++)
        {srtpproduct srtpproduct=WarehouseLayoutMapper.getproductByPid(list.get(i).getPid());
            srtpproduct.setX(Long.valueOf(list.get(i).getX()));
            srtpproduct.setY(Long.valueOf(list.get(i).getY()));
            srtpproduct.setSid(list.get(i).getSid());
            optimizeresult optimizeresult = new optimizeresult();
            optimizeresult.setId(srtpproduct.getId());
            optimizeresult.setTitle(srtpproduct.getTitle());
            optimizeresult.setCompany(srtpproduct.getCompany());
            optimizeresult.setPrice(srtpproduct.getPrice());
            optimizeresult.setNum(srtpproduct.getNum());
            optimizeresult.setImage(srtpproduct.getImage());
            optimizeresult.setStatus(srtpproduct.getStatus());
            optimizeresult.setX(srtpproduct.getX());
            optimizeresult.setY(srtpproduct.getY());
            optimizeresult.setSid(srtpproduct.getSid());
            reslist.add(optimizeresult);
        }
        Double score=getoptimizequalitydegree(list);
        reslist.get(0).setScore(score);
        return reslist;
    }




}
