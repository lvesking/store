package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.GoodsMapper;

public class TestGoods {

	//查询热门商品
	@Test
	public void testSelectByCategoryId(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		GoodsMapper goods=ac.getBean("goodsMapper",GoodsMapper.class);
		System.out.println(goods.selectByCategoryId(163, 0, 3));
		
		ac.close();
	}
	//查询三级分类下的商品数量
	@Test
	public void testSelectCount(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		GoodsMapper goods=ac.getBean("goodsMapper",GoodsMapper.class);
		System.out.println(goods.selectCount(163));
		ac.close();
	}
	//根据id查询商品信息
	@Test
	public void testSelectById(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		GoodsMapper goods=ac.getBean("goodsMapper",GoodsMapper.class);
		System.out.println(goods.selectById("100000425"));
		ac.close();
	}
	
}
