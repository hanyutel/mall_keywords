package cn.hanyuweb.mapper;

import java.util.List;

import cn.hanyuweb.bean.T_MALL_CLASS_1;
import cn.hanyuweb.bean.T_MALL_CLASS_2;
import cn.hanyuweb.bean.T_MALL_TRADE_MARK;

public interface GetJsonMapper {
	
	List<T_MALL_CLASS_1> queryAllMallClass1();
	List<T_MALL_CLASS_2> queryMallClassByFlbh1Id(int flbh1);
	List<T_MALL_TRADE_MARK> queryMallTradeMarkByFlbh1Id(int flbh1);
}
