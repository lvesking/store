package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;

public class TestCart {

	
	@Test
	public void testInsertCart(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		CartMapper cart1=ac.getBean("cartMapper",CartMapper.class);
		Cart car=new Cart();
		
		car.setUid(1);
		car.setGoodsId("100000425");
		car.setNum(1);
		cart1.insertCart(car);
	}
	@Test
	public void testSelectByUid(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		CartMapper ca=ac.getBean("cartMapper",CartMapper.class);
		System.out.println(ca.selectByUid(1));
		ac.close();
	}
	
	@Test
	public void testDeleteById(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		CartMapper ca=ac.getBean("cartMapper",CartMapper.class);
		Integer [] is=new Integer []{7,8,9,10};
		ca.deleteByIds(is);
		ac.close();
	}
	//修改购物车里商品的数量
	@Test
	public void testUpdateById(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		CartMapper ca=ac.getBean("cartMapper",CartMapper.class);
		ca.updateById(4, 6);
		ac.close();
	}
}
