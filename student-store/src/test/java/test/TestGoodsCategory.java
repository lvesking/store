package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsCategoryService;

public class TestGoodsCategory {

	@Test
	public void testGoodsCategory(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		GoodsCategoryMapper cn=ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
		System.out.println(cn.selectByParentId(161, 0, 3));
		System.out.println(cn.selectByParentId(161, null, null));
		ac.close();
	}
	@Test
	public void testgetByParentId(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
		IGoodsCategoryService ig=ac.getBean("goodsCategoryService",IGoodsCategoryService.class);
		System.out.println(ig.getByParentId(161, 2, 3));
		ac.close();
	}
	
	
}
