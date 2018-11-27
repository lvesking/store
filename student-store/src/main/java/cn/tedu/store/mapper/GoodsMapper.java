package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {

	//查询热门商品
	List<Goods> selectByCategoryId(
			@Param("categoryId") Integer categoryId,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	//查询三级分类下的商品总数
	Integer selectCount(Integer categoryId);
	//根据商品id查询商品其他信息
	Goods selectById(String id);
	
}
