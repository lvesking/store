package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.vo.CartVo;
@Service
public class CartService implements ICartService{

	@Resource
	private CartMapper cartMapper;
	public void addCart(Cart cart) {
		
		cartMapper.insertCart(cart);
	}
	public List<CartVo> getByUid(Integer uid) {
		return cartMapper.selectByUid(uid);
	}
	//批量删除购物车的商品
	public void remove(Integer[] ids) {
		cartMapper.deleteByIds(ids);
		
	}
	
	public void remove(Integer id) {
		cartMapper.deleteById(id);
		
	}
	public void updateNum(Integer id, Integer num) {
		cartMapper.updateById(id, num);
		
	}
	
	
	

}
