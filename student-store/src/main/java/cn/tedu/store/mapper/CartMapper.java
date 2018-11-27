package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface CartMapper {

	//插入购物车数据
	void insertCart(Cart cart);
	//根据Uid查询购物车
	List<CartVo> selectByUid(Integer uid);
	//批量 删除购物车的商品
	void deleteByIds(Integer [] ids );
	//单行删除
	void  deleteById(Integer id );
	//修改库存
	void updateById(@Param("id") Integer id,
					@Param("num") Integer num);
}
