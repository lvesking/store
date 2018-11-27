package cn.tedu.store.service;

import java.util.List;


import cn.tedu.store.bean.Goods;

public interface IGoodsService {

	//查询热门商品
	List<Goods> getByCategoryId(Integer categoryId,Integer offset,Integer count);
	//查询三级分类下的商品总数量
	Integer getCount(Integer categoryId);
	//根据id查询商品信息
	Goods getById(String id);
}
