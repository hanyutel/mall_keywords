package cn.hanyuweb.mapper;

import java.util.List;

import cn.hanyuweb.bean.OBJECT_T_MALL_SKU_KEYWORDS;

public interface ImportDataMapper {

	public List<OBJECT_T_MALL_SKU_KEYWORDS> select_sku_list_by_class_2_id(int class_2_id);
}
