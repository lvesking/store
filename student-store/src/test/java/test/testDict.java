package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.service.DictService;

public class testDict {
	
	//查询所有省份
	@Test
	public void testprovince(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
		DictMapper ds=ac.getBean("dictMapper",DictMapper.class);
		List<Province> di=ds.selectProvince();
		for(Province pr:di){
			System.out.println(pr);
		}
		ac.close();
	}
	//根据省份标号查询城市
		@Test
		public void testCity(){
			AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
			DictMapper ds=ac.getBean("dictMapper",DictMapper.class);
			List<City> li=ds.selectCity("360000");
			for(City lis:li){
				System.out.println(lis);
			}
			ac.close();
		}
		
		//根据城市标号查询区县
		@Test
		public void testArea(){
			AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
			DictMapper ds=ac.getBean("dictMapper",DictMapper.class);
			List<Area> li=ds.selectArea("360700");
			for(Area lis:li){
				System.out.println(lis);
			}
			ac.close();
		}
		//根据省份标号查询城市
		@Test
		public void testCitys(){
			AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
			DictService dic=ac.getBean("dictService",DictService.class);
			List<City> city=dic.getCity("360000");
			for(City li:city){
				System.out.println(li);
			}
			ac.close();
		}
		//根据城市标号查询区县
		@Test
		public void testAreas(){
			AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml","application-service.xml");
			DictService dic=ac.getBean("dictService",DictService.class);
			List<Area> area=dic.getArea("360700");
			for(Area li:area){
				System.out.println(li);
			}
			ac.close();
		}
		
		@Test
		public void testProvince(){
			AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-mapper.xml");
			DictMapper ds=ac.getBean("dictMapper",DictMapper.class);
			System.out.println(ds.selectByProvinceCode("360000"));
			System.out.println(ds.selectByCityCode("360700"));
			System.out.println(ds.selectByAreaCode("360730"));
			ac.close();
		}
		
	}

