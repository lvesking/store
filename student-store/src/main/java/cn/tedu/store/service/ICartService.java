package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

public interface ICartService {

	void addCart(Cart cart);
	List<CartVo>  getByUid(Integer uid);
	//批量删除购物车的商品
	void remove(Integer [] ids);
	
	void remove(Integer id);
	//修改库存
	void updateNum(Integer id,Integer num);
}
